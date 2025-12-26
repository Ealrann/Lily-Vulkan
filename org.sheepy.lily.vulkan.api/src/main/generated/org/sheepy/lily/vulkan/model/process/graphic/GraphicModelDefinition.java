package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.EnumAttributeBuilder;
import org.logoce.lmf.core.lang.builder.EnumBuilder;
import org.logoce.lmf.core.lang.builder.GenericParameterBuilder;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.sheepy.lily.core.model.application.ApplicationModelDefinition;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.MaintainerModelDefinition;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.ExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.ICommandBuffer;
import org.sheepy.lily.vulkan.model.process.IExecutionAcquirer;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessConfiguration;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionManager;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.lily.vulkan.model.process.VkPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.builder.AttachmentPkgBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.AttachmentRefBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.AttachmentRefPkgBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.AttributeDescriptionBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.BindIndexBufferBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.BindVertexBufferBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.BlitTaskBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.BlitToSwapImageBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.ColorAttachmentBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.ColorDomainBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.CompositorBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.DepthAttachmentBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.DrawBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.DrawIndexedBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.FramebufferConfigurationBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.GraphicAcquirerBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.GraphicCommandBufferBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.GraphicConfigurationBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.GraphicExecutionManagerBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.GraphicExecutionRecorderBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.GraphicProcessBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.GraphicsPipelineBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.ImageAttachmentBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.ImageViewsBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.InputDescriptorBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.PhysicalSurfaceBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.RenderPassBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.SetScissorBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.SetViewportBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.SubpassBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.SwapImageAttachmentBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.SwapImageBarrierBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.SwapchainConfigurationBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.VertexBindingBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.VertexInputStateBuilder;
import org.sheepy.lily.vulkan.model.vulkan.IResourceContainer;
import org.sheepy.lily.vulkan.model.vulkan.VulkanModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;
import org.sheepy.vulkan.model.barrier.BarrierModelDefinition;

public interface GraphicModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<GraphicConfiguration> GRAPHIC_CONFIGURATION = new GroupBuilder<GraphicConfiguration>().name("GraphicConfiguration").concrete(true).addInclude(() -> new IncludeBuilder<ProcessConfiguration>().group(() -> ProcessModelDefinition.Groups.PROCESS_CONFIGURATION).build()).addFeatures(GraphicConfiguration.Features.ALL).lmBuilder(new BuilderSupplier<>(GraphicConfigurationBuilder::new)).build();
    Group<GraphicExecutionManager> GRAPHIC_EXECUTION_MANAGER = new GroupBuilder<GraphicExecutionManager>().name("GraphicExecutionManager").concrete(true).addInclude(() -> new IncludeBuilder<ProcessExecutionManager>().group(() -> ProcessModelDefinition.Groups.PROCESS_EXECUTION_MANAGER).build()).addFeatures(GraphicExecutionManager.Features.ALL).lmBuilder(new BuilderSupplier<>(GraphicExecutionManagerBuilder::new)).build();
    Group<GraphicExecutionRecorder> GRAPHIC_EXECUTION_RECORDER = new GroupBuilder<GraphicExecutionRecorder>().name("GraphicExecutionRecorder").concrete(true).addInclude(() -> new IncludeBuilder<ExecutionRecorder>().group(() -> ProcessModelDefinition.Groups.EXECUTION_RECORDER).build()).addFeatures(GraphicExecutionRecorder.Features.ALL).lmBuilder(new BuilderSupplier<>(GraphicExecutionRecorderBuilder::new)).build();
    Group<ColorDomain> COLOR_DOMAIN = new GroupBuilder<ColorDomain>().name("ColorDomain").concrete(true).addFeatures(ColorDomain.Features.ALL).lmBuilder(new BuilderSupplier<>(ColorDomainBuilder::new)).build();
    Group<PhysicalSurface> PHYSICAL_SURFACE = new GroupBuilder<PhysicalSurface>().name("PhysicalSurface").concrete(true).addFeatures(PhysicalSurface.Features.ALL).lmBuilder(new BuilderSupplier<>(PhysicalSurfaceBuilder::new)).build();
    Group<SwapchainConfiguration> SWAPCHAIN_CONFIGURATION = new GroupBuilder<SwapchainConfiguration>().name("SwapchainConfiguration").concrete(true).addFeatures(SwapchainConfiguration.Features.ALL).lmBuilder(new BuilderSupplier<>(SwapchainConfigurationBuilder::new)).build();
    Group<FramebufferConfiguration> FRAMEBUFFER_CONFIGURATION = new GroupBuilder<FramebufferConfiguration>().name("FramebufferConfiguration").concrete(true).addFeatures(FramebufferConfiguration.Features.ALL).lmBuilder(new BuilderSupplier<>(FramebufferConfigurationBuilder::new)).build();
    Group<ImageViews> IMAGE_VIEWS = new GroupBuilder<ImageViews>().name("ImageViews").concrete(true).addFeatures(ImageViews.Features.ALL).lmBuilder(new BuilderSupplier<>(ImageViewsBuilder::new)).build();
    Group<RenderPass> RENDER_PASS = new GroupBuilder<RenderPass>().name("RenderPass").concrete(true).addFeatures(RenderPass.Features.ALL).lmBuilder(new BuilderSupplier<>(RenderPassBuilder::new)).build();
    Group<Attachment> ATTACHMENT = new GroupBuilder<Attachment>().name("Attachment").addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addInclude(() -> new IncludeBuilder<IVulkanImage>().group(() -> VulkanResourceModelDefinition.Groups.I_VULKAN_IMAGE).build()).addFeatures(Attachment.Features.ALL).build();
    Group<SwapImageAttachment> SWAP_IMAGE_ATTACHMENT = new GroupBuilder<SwapImageAttachment>().name("SwapImageAttachment").concrete(true).addInclude(() -> new IncludeBuilder<Attachment>().group(() -> ATTACHMENT).build()).addFeatures(SwapImageAttachment.Features.ALL).lmBuilder(new BuilderSupplier<>(SwapImageAttachmentBuilder::new)).build();
    Group<ExtraAttachment> EXTRA_ATTACHMENT = new GroupBuilder<ExtraAttachment>().name("ExtraAttachment").addInclude(() -> new IncludeBuilder<Attachment>().group(() -> ATTACHMENT).build()).addFeatures(ExtraAttachment.Features.ALL).build();
    Group<ImageAttachment> IMAGE_ATTACHMENT = new GroupBuilder<ImageAttachment>().name("ImageAttachment").concrete(true).addInclude(() -> new IncludeBuilder<ExtraAttachment>().group(() -> EXTRA_ATTACHMENT).build()).addFeatures(ImageAttachment.Features.ALL).lmBuilder(new BuilderSupplier<>(ImageAttachmentBuilder::new)).build();
    Group<DepthAttachment> DEPTH_ATTACHMENT = new GroupBuilder<DepthAttachment>().name("DepthAttachment").concrete(true).addInclude(() -> new IncludeBuilder<ExtraAttachment>().group(() -> EXTRA_ATTACHMENT).build()).addFeatures(DepthAttachment.Features.ALL).lmBuilder(new BuilderSupplier<>(DepthAttachmentBuilder::new)).build();
    Group<ColorAttachment> COLOR_ATTACHMENT = new GroupBuilder<ColorAttachment>().name("ColorAttachment").concrete(true).addInclude(() -> new IncludeBuilder<ExtraAttachment>().group(() -> EXTRA_ATTACHMENT).build()).addFeatures(ColorAttachment.Features.ALL).lmBuilder(new BuilderSupplier<>(ColorAttachmentBuilder::new)).build();
    Group<AttachmentPkg> ATTACHMENT_PKG = new GroupBuilder<AttachmentPkg>().name("AttachmentPkg").concrete(true).addFeatures(AttachmentPkg.Features.ALL).lmBuilder(new BuilderSupplier<>(AttachmentPkgBuilder::new)).build();
    Group<AttachmentRefPkg> ATTACHMENT_REF_PKG = new GroupBuilder<AttachmentRefPkg>().name("AttachmentRefPkg").concrete(true).addFeatures(AttachmentRefPkg.Features.ALL).lmBuilder(new BuilderSupplier<>(AttachmentRefPkgBuilder::new)).build();
    Group<AttachmentRef> ATTACHMENT_REF = new GroupBuilder<AttachmentRef>().name("AttachmentRef").concrete(true).addFeatures(AttachmentRef.Features.ALL).lmBuilder(new BuilderSupplier<>(AttachmentRefBuilder::new)).build();
    Group<Subpass> SUBPASS = new GroupBuilder<Subpass>().name("Subpass").concrete(true).addInclude(() -> new IncludeBuilder<IResourceContainer>().group(() -> VulkanModelDefinition.Groups.I_RESOURCE_CONTAINER).build()).addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(Subpass.Features.ALL).lmBuilder(new BuilderSupplier<>(SubpassBuilder::new)).build();
    Group<GraphicProcess> GRAPHIC_PROCESS = new GroupBuilder<GraphicProcess>().name("GraphicProcess").concrete(true).addInclude(() -> new IncludeBuilder<AbstractProcess>().group(() -> ProcessModelDefinition.Groups.ABSTRACT_PROCESS).build()).addInclude(() -> new IncludeBuilder<Maintainable<?>>().group(() -> MaintainerModelDefinition.Groups.MAINTAINABLE).addParameter(() -> new GenericParameterBuilder().type(() -> GraphicModelDefinition.Groups.GRAPHIC_PROCESS).build()).build()).addFeatures(GraphicProcess.Features.ALL).lmBuilder(new BuilderSupplier<>(GraphicProcessBuilder::new)).build();
    Group<GraphicsPipeline> GRAPHICS_PIPELINE = new GroupBuilder<GraphicsPipeline>().name("GraphicsPipeline").concrete(true).addInclude(() -> new IncludeBuilder<VkPipeline>().group(() -> ProcessModelDefinition.Groups.VK_PIPELINE).build()).addInclude(() -> new IncludeBuilder<Maintainable<?>>().group(() -> MaintainerModelDefinition.Groups.MAINTAINABLE).addParameter(() -> new GenericParameterBuilder().type(() -> GraphicModelDefinition.Groups.GRAPHICS_PIPELINE).build()).build()).addFeatures(GraphicsPipeline.Features.ALL).lmBuilder(new BuilderSupplier<>(GraphicsPipelineBuilder::new)).build();
    Group<SwapImageBarrier> SWAP_IMAGE_BARRIER = new GroupBuilder<SwapImageBarrier>().name("SwapImageBarrier").concrete(true).addInclude(() -> new IncludeBuilder<AbstractImageBarrier>().group(() -> BarrierModelDefinition.Groups.ABSTRACT_IMAGE_BARRIER).build()).addFeatures(SwapImageBarrier.Features.ALL).lmBuilder(new BuilderSupplier<>(SwapImageBarrierBuilder::new)).build();
    Group<AbstractBlitTask> ABSTRACT_BLIT_TASK = new GroupBuilder<AbstractBlitTask>().name("AbstractBlitTask").addInclude(() -> new IncludeBuilder<IPipelineTask>().group(() -> ProcessModelDefinition.Groups.I_PIPELINE_TASK).build()).addFeatures(AbstractBlitTask.Features.ALL).build();
    Group<BlitToSwapImage> BLIT_TO_SWAP_IMAGE = new GroupBuilder<BlitToSwapImage>().name("BlitToSwapImage").concrete(true).addInclude(() -> new IncludeBuilder<AbstractBlitTask>().group(() -> ABSTRACT_BLIT_TASK).build()).addFeatures(BlitToSwapImage.Features.ALL).lmBuilder(new BuilderSupplier<>(BlitToSwapImageBuilder::new)).build();
    Group<BlitTask> BLIT_TASK = new GroupBuilder<BlitTask>().name("BlitTask").concrete(true).addInclude(() -> new IncludeBuilder<AbstractBlitTask>().group(() -> ABSTRACT_BLIT_TASK).build()).addFeatures(BlitTask.Features.ALL).lmBuilder(new BuilderSupplier<>(BlitTaskBuilder::new)).build();
    Group<DrawIndexed> DRAW_INDEXED = new GroupBuilder<DrawIndexed>().name("DrawIndexed").concrete(true).addInclude(() -> new IncludeBuilder<IPipelineTask>().group(() -> ProcessModelDefinition.Groups.I_PIPELINE_TASK).build()).addFeatures(DrawIndexed.Features.ALL).lmBuilder(new BuilderSupplier<>(DrawIndexedBuilder::new)).build();
    Group<Draw> DRAW = new GroupBuilder<Draw>().name("Draw").concrete(true).addInclude(() -> new IncludeBuilder<IPipelineTask>().group(() -> ProcessModelDefinition.Groups.I_PIPELINE_TASK).build()).addFeatures(Draw.Features.ALL).lmBuilder(new BuilderSupplier<>(DrawBuilder::new)).build();
    Group<VertexInputState> VERTEX_INPUT_STATE = new GroupBuilder<VertexInputState>().name("VertexInputState").concrete(true).addFeatures(VertexInputState.Features.ALL).lmBuilder(new BuilderSupplier<>(VertexInputStateBuilder::new)).build();
    Group<InputDescriptor> INPUT_DESCRIPTOR = new GroupBuilder<InputDescriptor>().name("InputDescriptor").concrete(true).addFeatures(InputDescriptor.Features.ALL).lmBuilder(new BuilderSupplier<>(InputDescriptorBuilder::new)).build();
    Group<AttributeDescription> ATTRIBUTE_DESCRIPTION = new GroupBuilder<AttributeDescription>().name("AttributeDescription").concrete(true).addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(AttributeDescription.Features.ALL).lmBuilder(new BuilderSupplier<>(AttributeDescriptionBuilder::new)).build();
    Group<BindVertexBuffer> BIND_VERTEX_BUFFER = new GroupBuilder<BindVertexBuffer>().name("BindVertexBuffer").concrete(true).addInclude(() -> new IncludeBuilder<IPipelineTask>().group(() -> ProcessModelDefinition.Groups.I_PIPELINE_TASK).build()).addFeatures(BindVertexBuffer.Features.ALL).lmBuilder(new BuilderSupplier<>(BindVertexBufferBuilder::new)).build();
    Group<SetScissor> SET_SCISSOR = new GroupBuilder<SetScissor>().name("SetScissor").concrete(true).addInclude(() -> new IncludeBuilder<IPipelineTask>().group(() -> ProcessModelDefinition.Groups.I_PIPELINE_TASK).build()).addFeatures(SetScissor.Features.ALL).lmBuilder(new BuilderSupplier<>(SetScissorBuilder::new)).build();
    Group<SetViewport> SET_VIEWPORT = new GroupBuilder<SetViewport>().name("SetViewport").concrete(true).addInclude(() -> new IncludeBuilder<IPipelineTask>().group(() -> ProcessModelDefinition.Groups.I_PIPELINE_TASK).build()).addFeatures(SetViewport.Features.ALL).lmBuilder(new BuilderSupplier<>(SetViewportBuilder::new)).build();
    Group<VertexBinding> VERTEX_BINDING = new GroupBuilder<VertexBinding>().name("VertexBinding").concrete(true).addFeatures(VertexBinding.Features.ALL).lmBuilder(new BuilderSupplier<>(VertexBindingBuilder::new)).build();
    Group<BindIndexBuffer> BIND_INDEX_BUFFER = new GroupBuilder<BindIndexBuffer>().name("BindIndexBuffer").concrete(true).addInclude(() -> new IncludeBuilder<IPipelineTask>().group(() -> ProcessModelDefinition.Groups.I_PIPELINE_TASK).build()).addFeatures(BindIndexBuffer.Features.ALL).lmBuilder(new BuilderSupplier<>(BindIndexBufferBuilder::new)).build();
    Group<Compositor> COMPOSITOR = new GroupBuilder<Compositor>().name("Compositor").concrete(true).addInclude(() -> new IncludeBuilder<ICompositor>().group(() -> ApplicationModelDefinition.Groups.I_COMPOSITOR).build()).addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(Compositor.Features.ALL).lmBuilder(new BuilderSupplier<>(CompositorBuilder::new)).build();
    Group<GraphicCommandBuffer> GRAPHIC_COMMAND_BUFFER = new GroupBuilder<GraphicCommandBuffer>().name("GraphicCommandBuffer").concrete(true).addInclude(() -> new IncludeBuilder<ICommandBuffer>().group(() -> ProcessModelDefinition.Groups.I_COMMAND_BUFFER).build()).addFeatures(GraphicCommandBuffer.Features.ALL).lmBuilder(new BuilderSupplier<>(GraphicCommandBufferBuilder::new)).build();
    Group<GraphicAcquirer> GRAPHIC_ACQUIRER = new GroupBuilder<GraphicAcquirer>().name("GraphicAcquirer").concrete(true).addInclude(() -> new IncludeBuilder<IExecutionAcquirer>().group(() -> ProcessModelDefinition.Groups.I_EXECUTION_ACQUIRER).build()).addFeatures(GraphicAcquirer.Features.ALL).lmBuilder(new BuilderSupplier<>(GraphicAcquirerBuilder::new)).build();
    List<Group<?>> ALL = List.of(GRAPHIC_CONFIGURATION, GRAPHIC_EXECUTION_MANAGER, GRAPHIC_EXECUTION_RECORDER, COLOR_DOMAIN, PHYSICAL_SURFACE, SWAPCHAIN_CONFIGURATION, FRAMEBUFFER_CONFIGURATION, IMAGE_VIEWS, RENDER_PASS, ATTACHMENT, SWAP_IMAGE_ATTACHMENT, EXTRA_ATTACHMENT, IMAGE_ATTACHMENT, DEPTH_ATTACHMENT, COLOR_ATTACHMENT, ATTACHMENT_PKG, ATTACHMENT_REF_PKG, ATTACHMENT_REF, SUBPASS, GRAPHIC_PROCESS, GRAPHICS_PIPELINE, SWAP_IMAGE_BARRIER, ABSTRACT_BLIT_TASK, BLIT_TO_SWAP_IMAGE, BLIT_TASK, DRAW_INDEXED, DRAW, VERTEX_INPUT_STATE, INPUT_DESCRIPTOR, ATTRIBUTE_DESCRIPTION, BIND_VERTEX_BUFFER, SET_SCISSOR, SET_VIEWPORT, VERTEX_BINDING, BIND_INDEX_BUFFER, COMPOSITOR, GRAPHIC_COMMAND_BUFFER, GRAPHIC_ACQUIRER);
  }

  interface Units {
    List<Unit<?>> ALL = List.of();
  }

  interface Enums {
    Enum<EAttachmentType> E_ATTACHMENT_TYPE = new EnumBuilder<EAttachmentType>().name("EAttachmentType").addLiterals(List.of("Color", "0", "Depth", "1", "Input", "2")).addAttribute(() -> new EnumAttributeBuilder().name("value").unit(() -> LMCoreModelDefinition.Units.INT).build()).build();
    List<Enum<?>> ALL = List.of(E_ATTACHMENT_TYPE);
  }

  interface Aliases {
    List<Alias> ALL = List.of();
  }

  interface JavaWrappers {
    List<JavaWrapper<?>> ALL = List.of();
  }
}
