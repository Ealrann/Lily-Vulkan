package org.sheepy.vulkan.model.graphicpipeline;

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

public final class GraphicPipelineModelPackage implements IModelPackage {
  public static final GraphicPipelineModelPackage Instance = new GraphicPipelineModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("GraphicPipeline").domain("org.sheepy.vulkan.model").addImports(List.of("org.sheepy.lily.core.model.Types", "org.sheepy.vulkan.model.Enumeration")).genNamePackage(true).lmPackage(Instance).addGroups(GraphicPipelineModelDefinition.Groups.ALL).addEnums(GraphicPipelineModelDefinition.Enums.ALL).addUnits(GraphicPipelineModelDefinition.Units.ALL).addAliases(GraphicPipelineModelDefinition.Aliases.ALL).addJavaWrappers(GraphicPipelineModelDefinition.JavaWrappers.ALL).build();

  private GraphicPipelineModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == GraphicPipelineModelDefinition.Groups.COLOR_BLEND) return Optional.of((IFeaturedObject.Builder<T>) ColorBlend.builder());
    else if (group == GraphicPipelineModelDefinition.Groups.COLOR_BLEND_ATTACHMENT) return Optional.of((IFeaturedObject.Builder<T>) ColorBlendAttachment.builder());
    else if (group == GraphicPipelineModelDefinition.Groups.INPUT_ASSEMBLY) return Optional.of((IFeaturedObject.Builder<T>) InputAssembly.builder());
    else if (group == GraphicPipelineModelDefinition.Groups.RASTERIZER) return Optional.of((IFeaturedObject.Builder<T>) Rasterizer.builder());
    else if (group == GraphicPipelineModelDefinition.Groups.DYNAMIC_STATE) return Optional.of((IFeaturedObject.Builder<T>) DynamicState.builder());
    else if (group == GraphicPipelineModelDefinition.Groups.STATIC_VIEWPORT_STATE) return Optional.of((IFeaturedObject.Builder<T>) StaticViewportState.builder());
    else if (group == GraphicPipelineModelDefinition.Groups.DYNAMIC_VIEWPORT_STATE) return Optional.of((IFeaturedObject.Builder<T>) DynamicViewportState.builder());
    else if (group == GraphicPipelineModelDefinition.Groups.VIEWPORT) return Optional.of((IFeaturedObject.Builder<T>) Viewport.builder());
    else if (group == GraphicPipelineModelDefinition.Groups.CINEMA_VIEWPORT) return Optional.of((IFeaturedObject.Builder<T>) CinemaViewport.builder());
    else if (group == GraphicPipelineModelDefinition.Groups.SCISSOR) return Optional.of((IFeaturedObject.Builder<T>) Scissor.builder());
    else if (group == GraphicPipelineModelDefinition.Groups.DEPTH_STENCIL_STATE) return Optional.of((IFeaturedObject.Builder<T>) DepthStencilState.builder());
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<T> resolveEnumLiteral(Enum<T> enum_, String value) {
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<IJavaWrapperConverter<T>> resolveJavaWrapperConverter(
      JavaWrapper<T> wrapper) {
    return Optional.empty();
  }
}
