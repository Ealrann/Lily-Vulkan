package org.sheepy.lily.vulkan.extra.rendering;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.lwjgl.BufferUtils;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Autorun;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.maintainer.MaintainerUtil;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IResourceProviderAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.IStructureAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.rendering.builder.PipelineContext;
import org.sheepy.lily.vulkan.extra.rendering.builder.StructureInstaller;
import org.sheepy.lily.vulkan.model.VulkanFactory;
import org.sheepy.lily.vulkan.model.process.ProcessFactory;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.resource.DescriptedResource;
import org.sheepy.lily.vulkan.model.resource.ResourceFactory;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

@Statefull
@Adapter(scope = GenericRenderer.class, scopeInheritance = true)
public final class GenericRendererMaintainerAdapter<T extends Structure<?>>
		implements IVulkanAdapter
{
	public static final int PUSH_BUFFER_SIZE = 2097152;

	private static final EClass RENDERER_ECLASS = RenderingPackage.Literals.GENERIC_RENDERER;

	private final GenericRenderer<T> maintainer;
	private final GraphicProcess graphicProcess;
	private final List<PipelineContext> contexts = new ArrayList<>();
	private final List<DescriptedResource> commonResources;

	private PipelineContext commonPipeline = null;

	public GenericRendererMaintainerAdapter(GenericRenderer<T> maintainer)
	{
		this.maintainer = maintainer;
		this.graphicProcess = ModelUtil.findParent(maintainer, GraphicProcess.class);
		this.commonResources = List.copyOf(gatherCommonResources(maintainer));
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
		final var structures = maintainer.getRenderedStructures().stream();
		final var structInstaller = new StructureInstaller<>(maintainer);
		final var presentedEClass = ModelUtil.resolveGenericType(maintainer, RENDERER_ECLASS);

		final var pipContextBuilder = createPipelineContextBuilder(structInstaller);

		structures.forEach(s -> preparePipeline(pipContextBuilder, structInstaller, s));

		if (DebugUtil.DEBUG_ENABLED)
		{
			printDebugInfo(presentedEClass);
		}
	}

	private Supplier<PipelineContext> createPipelineContextBuilder(StructureInstaller<?> structInstaller)
	{
		final int pipelineCount = graphicProcess.getPartPkg().getParts().size();
		final boolean needRecreatePipeline = structInstaller.hasDynamicDescriptors
				|| structInstaller.hasIndexData;

		if (needRecreatePipeline)
		{
			final var pipelineIndex = new AtomicInteger(pipelineCount);

			// Will recreate pipeline each call
			return () ->
			{
				final var res = newPipelineContext(pipelineIndex.getAndIncrement());
				contexts.add(res);
				return res;
			};
		}
		else
		{
			// Keep the same pipeline
			return () ->
			{
				if (commonPipeline == null)
				{
					commonPipeline = newPipelineContext(pipelineCount + 1);
					contexts.add(commonPipeline);
				}
				return commonPipeline;
			};
		}
	}

	private void preparePipeline(	Supplier<PipelineContext> contextBuilder,
									final StructureInstaller<T> installer,
									T structure)
	{
		final var structureAdapter = IStructureAdapter.adapt(structure);
		for (int i = 0; i < structureAdapter.getPartCount(); i++)
		{
			final var context = contextBuilder.get();
			installer.install(context, structure, i);
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

	private static List<DescriptedResource> gatherCommonResources(GenericRenderer<?> maintainer)
	{
		final List<DescriptedResource> commonResources = new ArrayList<>();
		final var resourceProvider = maintainer.getCommonResourceProvider();
		if (resourceProvider != null)
		{
			final var providerAdapter = IResourceProviderAdapter.adapt(resourceProvider);
			commonResources.addAll(providerAdapter.getResources(resourceProvider));
		}
		return commonResources;
	}

	private void printDebugInfo(final EClassifier presentedEClass)
	{
		final var classifier = presentedEClass.getInstanceClass();
		final var name = maintainer.getName();
		final var className = classifier.getSimpleName();
		final int count = contexts.size();
		System.out
				.println(String.format("Create %d pipelines for %s [%s].", count, name, className));
	}
}