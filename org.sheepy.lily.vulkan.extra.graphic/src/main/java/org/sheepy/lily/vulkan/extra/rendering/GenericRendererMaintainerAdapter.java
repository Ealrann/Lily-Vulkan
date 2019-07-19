package org.sheepy.lily.vulkan.extra.rendering;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.emf.ecore.EClass;
import org.lwjgl.BufferUtils;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Autorun;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.maintainer.MaintainerUtil;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IPresentationAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IResourceProviderAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.rendering.PresentationContext.PipelineContext;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.resource.DescriptedResource;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

@Statefull
@Adapter(scope = GenericRenderer.class, scopeInheritance = true)
public final class GenericRendererMaintainerAdapter<T extends Presentation> implements IVulkanAdapter
{
	private static final EClass RENDERER_ECLASS = RenderingPackage.Literals.GENERIC_RENDERER;

	public static final int PUSH_BUFFER_SIZE = 2097152;

	private final GenericRenderer<T> maintainer;
	private final GraphicProcess graphicProcess;

	private final List<PresentationContext<T>> contexts = new ArrayList<>();

	private final List<DescriptedResource> commonResources;

	public GenericRendererMaintainerAdapter(GenericRenderer<T> maintainer)
	{
		this.maintainer = maintainer;
		this.graphicProcess = ModelUtil.findParent(maintainer, GraphicProcess.class);
		this.commonResources = List.copyOf(getCommonResources(maintainer));
	}

	private List<DescriptedResource> getCommonResources(GenericRenderer<T> maintainer)
	{
		final List<DescriptedResource> commonResources = new ArrayList<>();
		final var commonResourceProvider = maintainer.getCommonResourceProvider();
		if (commonResourceProvider != null)
		{
			final var resourceProviderAdapter = IResourceProviderAdapter.adapt(commonResourceProvider);
			commonResources.addAll(resourceProviderAdapter.getResources(commonResourceProvider));
		}
		return commonResources;
	}

	@Autorun
	public void load()
	{
		if (maintainer.isEnabled())
		{
			buildPipelines();
		}
	}

	private void buildPipelines()
	{
		final var presentationPkg = maintainer.getPresentationPkg();
		final var builder = new PresentationContext.Builder<T>(maintainer);
		final var presentationStream = presentationPkg.getPresentations().stream();
		final var pipelineIndex = new AtomicInteger(graphicProcess.getPartPkg().getParts().size());

		final var presentedEClass = ModelUtil.resolveGenericType(maintainer, RENDERER_ECLASS);
		@SuppressWarnings("unchecked")
		final var presentedClass = (Class<T>) presentedEClass.getInstanceClass();

		final boolean needRecreatePipelines = builder.containsDynamicDescriptors || builder.containsIndexData;
		final var commonPipeline = needRecreatePipelines ? null : newPipelineContext(pipelineIndex.getAndIncrement());

		presentationStream.filter(presentedClass::isInstance).map(presentedClass::cast).forEach(presentation -> {
			final var meshAdapter = IPresentationAdapter.adapt(presentation);
			for (int i = 0; i < meshAdapter.getPartCount(); i++)
			{
				final var pipelineContext = commonPipeline != null
						? commonPipeline
						: newPipelineContext(pipelineIndex.getAndIncrement());
				final var meshContext = builder.setup(pipelineContext, presentation, i);
				contexts.add(meshContext);
			}
		});

		if (DebugUtil.DEBUG_ENABLED)
		{
			final var name = presentedClass.getSimpleName();
			final int count = contexts.size();
			System.out.println(String.format("Create %d pipelines for %s.", count, name));
		}
	}

	private PipelineContext newPipelineContext(int index)
	{
		final var pipeline = MaintainerUtil.instanciateMaintainer(maintainer);

		pipeline.setTaskPkg(ProcessFactory.eINSTANCE.createTaskPkg());
		pipeline.setResourcePkg(VulkanFactory.eINSTANCE.createResourcePkg());
		pipeline.setDescriptorSetPkg(ResourceFactory.eINSTANCE.createDescriptorSetPkg());

		final var constantsData = BufferUtils.createByteBuffer(4);
		constantsData.putInt(0, index);
		pipeline.setSpecializationData(constantsData);

		final var constantBuffer = maintainer.getConstantBuffer();
		if (constantBuffer != null)
		{
			final var pushConstant = ProcessFactory.eINSTANCE.createPushConstantBuffer();
			pushConstant.getStages().add(EShaderStage.VERTEX_BIT);
			pushConstant.getStages().add(EShaderStage.FRAGMENT_BIT);
			pushConstant.setBuffer(constantBuffer);
			pipeline.getTaskPkg().getTasks().add(pushConstant);
		}

		if (commonResources.isEmpty() == false)
		{
			final var descriptorSet = ResourceFactory.eINSTANCE.createDescriptorSet();
			descriptorSet.getDescriptors().addAll(commonResources);
			pipeline.getDescriptorSetPkg().getDescriptorSets().add(descriptorSet);
		}

		graphicProcess.getPartPkg().getParts().add(pipeline);

		return new PipelineContext(pipeline, maintainer.getPushBuffer());
	}
}