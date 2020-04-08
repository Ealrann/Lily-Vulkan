package org.sheepy.lily.vulkan.process.graphic.process;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.sheepy.lily.core.api.notification.observatory.IObservatory;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.vulkan.api.device.IVulkanContext;
import org.sheepy.lily.vulkan.api.view.ICompositor_SubpassProvider;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.process.graphic.pipeline.util.SubpassUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubpassManager
{
	private final IObservatory observatory;
	private final Map<ICompositor, Subpass> subpassMap = new HashMap<>();
	private final GraphicProcess process;
	private IVulkanContext context;

	public SubpassManager(GraphicProcess process)
	{
		this.process = process;
		observatory = IObservatoryBuilder.newObservatoryBuilder()
										 .explore(ApplicationPackage.Literals.SCENE__COMPOSITORS, ICompositor.class)
										 .gatherBulk(this::installCompositors, this::uninstallCompositors)
										 .build();
	}

	public void start(final IVulkanContext context)
	{
		this.context = context;
		final var application = ModelUtil.getApplication(process);
		final var scene = application.getScene();

		observatory.observe(scene);
	}

	public void stop(final IVulkanContext context)
	{
		final var application = ModelUtil.getApplication(process);
		final var scene = application.getScene();

		observatory.shut(scene);
		this.context = null;
	}

	private void installCompositors(List<ICompositor> compositors)
	{
		for (int i = 0; i < compositors.size(); i++)
		{
			final var compositor = compositors.get(i);
			setupScenePart(compositor);
		}
	}

	private void uninstallCompositors(List<ICompositor> compositors)
	{
		for (int i = 0; i < compositors.size(); i++)
		{
			final var compositor = compositors.get(i);
			final var subpass = subpassMap.get(compositor);
			EcoreUtil.delete(subpass);
			subpassMap.remove(compositor);
		}
	}

	private void setupScenePart(ICompositor part)
	{
		final var subpass = buildSubpass(part);
		final int index = findAvailableIndex(process);

		subpass.setCompositor(part);
		subpass.setSubpassIndex(index);
		process.getSubpasses().add(subpass);

		subpassMap.put(part, subpass);
	}

	private static int findAvailableIndex(GraphicProcess process)
	{
		final var subpasses = process.getSubpasses();
		final int size = subpasses.size();
		final int maxIndex = SubpassUtil.maxGraphicIndex(subpasses);

		final boolean[] reservedIndices = new boolean[Math.max(size, maxIndex) + 1];
		for (int i = 0; i < size; i++)
		{
			final var subpass = subpasses.get(i);
			if (SubpassUtil.isGraphic(subpass))
			{
				reservedIndices[subpass.getSubpassIndex()] = true;
			}
		}

		for (int i = 0; i < reservedIndices.length; i++)
		{
			if (reservedIndices[i] == false)
			{
				return i;
			}
		}
		return 0;
	}

	private <T extends ICompositor> Subpass buildSubpass(T scenePart)
	{
		final var subpassProvider = scenePart.<ICompositor_SubpassProvider<T>>adaptGeneric(ICompositor_SubpassProvider.class);
		return subpassProvider.build(scenePart, process, context);
	}
}
