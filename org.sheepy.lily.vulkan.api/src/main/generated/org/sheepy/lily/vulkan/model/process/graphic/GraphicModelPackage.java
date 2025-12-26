package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import java.util.Optional;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IJavaWrapperConverter;
import org.logoce.lmf.core.api.model.IModelPackage;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.MetaModel;
import org.logoce.lmf.core.lang.builder.MetaModelBuilder;

public final class GraphicModelPackage implements IModelPackage {
  public static final GraphicModelPackage Instance = new GraphicModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Graphic").domain("org.sheepy.lily.vulkan.model.process").addImports(List.of("org.sheepy.lily.core.model.Application", "org.sheepy.lily.core.model.Maintainer", "org.sheepy.lily.core.model.Types", "org.sheepy.lily.core.model.Variable", "org.sheepy.lily.vulkan.model.Process", "org.sheepy.lily.vulkan.model.Vulkan", "org.sheepy.lily.vulkan.model.VulkanResource", "org.sheepy.vulkan.model.Barrier", "org.sheepy.vulkan.model.Enumeration", "org.sheepy.vulkan.model.GraphicPipeline")).genNamePackage(true).lmPackage(Instance).addGroups(GraphicModelDefinition.Groups.ALL).addEnums(GraphicModelDefinition.Enums.ALL).addUnits(GraphicModelDefinition.Units.ALL).addAliases(GraphicModelDefinition.Aliases.ALL).addJavaWrappers(GraphicModelDefinition.JavaWrappers.ALL).build();

  private GraphicModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == GraphicModelDefinition.Groups.GRAPHIC_CONFIGURATION) return Optional.of((IFeaturedObject.Builder<T>) GraphicConfiguration.builder());
    else if (group == GraphicModelDefinition.Groups.GRAPHIC_EXECUTION_MANAGER) return Optional.of((IFeaturedObject.Builder<T>) GraphicExecutionManager.builder());
    else if (group == GraphicModelDefinition.Groups.GRAPHIC_EXECUTION_RECORDER) return Optional.of((IFeaturedObject.Builder<T>) GraphicExecutionRecorder.builder());
    else if (group == GraphicModelDefinition.Groups.COLOR_DOMAIN) return Optional.of((IFeaturedObject.Builder<T>) ColorDomain.builder());
    else if (group == GraphicModelDefinition.Groups.PHYSICAL_SURFACE) return Optional.of((IFeaturedObject.Builder<T>) PhysicalSurface.builder());
    else if (group == GraphicModelDefinition.Groups.SWAPCHAIN_CONFIGURATION) return Optional.of((IFeaturedObject.Builder<T>) SwapchainConfiguration.builder());
    else if (group == GraphicModelDefinition.Groups.FRAMEBUFFER_CONFIGURATION) return Optional.of((IFeaturedObject.Builder<T>) FramebufferConfiguration.builder());
    else if (group == GraphicModelDefinition.Groups.IMAGE_VIEWS) return Optional.of((IFeaturedObject.Builder<T>) ImageViews.builder());
    else if (group == GraphicModelDefinition.Groups.RENDER_PASS) return Optional.of((IFeaturedObject.Builder<T>) RenderPass.builder());
    else if (group == GraphicModelDefinition.Groups.SWAP_IMAGE_ATTACHMENT) return Optional.of((IFeaturedObject.Builder<T>) SwapImageAttachment.builder());
    else if (group == GraphicModelDefinition.Groups.IMAGE_ATTACHMENT) return Optional.of((IFeaturedObject.Builder<T>) ImageAttachment.builder());
    else if (group == GraphicModelDefinition.Groups.DEPTH_ATTACHMENT) return Optional.of((IFeaturedObject.Builder<T>) DepthAttachment.builder());
    else if (group == GraphicModelDefinition.Groups.COLOR_ATTACHMENT) return Optional.of((IFeaturedObject.Builder<T>) ColorAttachment.builder());
    else if (group == GraphicModelDefinition.Groups.ATTACHMENT_PKG) return Optional.of((IFeaturedObject.Builder<T>) AttachmentPkg.builder());
    else if (group == GraphicModelDefinition.Groups.ATTACHMENT_REF_PKG) return Optional.of((IFeaturedObject.Builder<T>) AttachmentRefPkg.builder());
    else if (group == GraphicModelDefinition.Groups.ATTACHMENT_REF) return Optional.of((IFeaturedObject.Builder<T>) AttachmentRef.builder());
    else if (group == GraphicModelDefinition.Groups.SUBPASS) return Optional.of((IFeaturedObject.Builder<T>) Subpass.builder());
    else if (group == GraphicModelDefinition.Groups.GRAPHIC_PROCESS) return Optional.of((IFeaturedObject.Builder<T>) GraphicProcess.builder());
    else if (group == GraphicModelDefinition.Groups.GRAPHICS_PIPELINE) return Optional.of((IFeaturedObject.Builder<T>) GraphicsPipeline.builder());
    else if (group == GraphicModelDefinition.Groups.SWAP_IMAGE_BARRIER) return Optional.of((IFeaturedObject.Builder<T>) SwapImageBarrier.builder());
    else if (group == GraphicModelDefinition.Groups.BLIT_TO_SWAP_IMAGE) return Optional.of((IFeaturedObject.Builder<T>) BlitToSwapImage.builder());
    else if (group == GraphicModelDefinition.Groups.BLIT_TASK) return Optional.of((IFeaturedObject.Builder<T>) BlitTask.builder());
    else if (group == GraphicModelDefinition.Groups.DRAW_INDEXED) return Optional.of((IFeaturedObject.Builder<T>) DrawIndexed.builder());
    else if (group == GraphicModelDefinition.Groups.DRAW) return Optional.of((IFeaturedObject.Builder<T>) Draw.builder());
    else if (group == GraphicModelDefinition.Groups.VERTEX_INPUT_STATE) return Optional.of((IFeaturedObject.Builder<T>) VertexInputState.builder());
    else if (group == GraphicModelDefinition.Groups.INPUT_DESCRIPTOR) return Optional.of((IFeaturedObject.Builder<T>) InputDescriptor.builder());
    else if (group == GraphicModelDefinition.Groups.ATTRIBUTE_DESCRIPTION) return Optional.of((IFeaturedObject.Builder<T>) AttributeDescription.builder());
    else if (group == GraphicModelDefinition.Groups.BIND_VERTEX_BUFFER) return Optional.of((IFeaturedObject.Builder<T>) BindVertexBuffer.builder());
    else if (group == GraphicModelDefinition.Groups.SET_SCISSOR) return Optional.of((IFeaturedObject.Builder<T>) SetScissor.builder());
    else if (group == GraphicModelDefinition.Groups.SET_VIEWPORT) return Optional.of((IFeaturedObject.Builder<T>) SetViewport.builder());
    else if (group == GraphicModelDefinition.Groups.VERTEX_BINDING) return Optional.of((IFeaturedObject.Builder<T>) VertexBinding.builder());
    else if (group == GraphicModelDefinition.Groups.BIND_INDEX_BUFFER) return Optional.of((IFeaturedObject.Builder<T>) BindIndexBuffer.builder());
    else if (group == GraphicModelDefinition.Groups.COMPOSITOR) return Optional.of((IFeaturedObject.Builder<T>) Compositor.builder());
    else if (group == GraphicModelDefinition.Groups.GRAPHIC_COMMAND_BUFFER) return Optional.of((IFeaturedObject.Builder<T>) GraphicCommandBuffer.builder());
    else if (group == GraphicModelDefinition.Groups.GRAPHIC_ACQUIRER) return Optional.of((IFeaturedObject.Builder<T>) GraphicAcquirer.builder());
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<T> resolveEnumLiteral(Enum<T> enum_, String value) {
    if (enum_ == GraphicModelDefinition.Enums.E_ATTACHMENT_TYPE) return (Optional<T>) Optional.of(EAttachmentType.valueOf(value));
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<IJavaWrapperConverter<T>> resolveJavaWrapperConverter(
      JavaWrapper<T> wrapper) {
    return Optional.empty();
  }
}
