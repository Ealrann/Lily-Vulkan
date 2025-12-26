package org.sheepy.vulkan.model.graphicpipeline;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.sheepy.vulkan.model.graphicpipeline.builder.CinemaViewportBuilder;
import org.sheepy.vulkan.model.graphicpipeline.builder.ColorBlendAttachmentBuilder;
import org.sheepy.vulkan.model.graphicpipeline.builder.ColorBlendBuilder;
import org.sheepy.vulkan.model.graphicpipeline.builder.DepthStencilStateBuilder;
import org.sheepy.vulkan.model.graphicpipeline.builder.DynamicStateBuilder;
import org.sheepy.vulkan.model.graphicpipeline.builder.DynamicViewportStateBuilder;
import org.sheepy.vulkan.model.graphicpipeline.builder.InputAssemblyBuilder;
import org.sheepy.vulkan.model.graphicpipeline.builder.RasterizerBuilder;
import org.sheepy.vulkan.model.graphicpipeline.builder.ScissorBuilder;
import org.sheepy.vulkan.model.graphicpipeline.builder.StaticViewportStateBuilder;
import org.sheepy.vulkan.model.graphicpipeline.builder.ViewportBuilder;

public interface GraphicPipelineModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<ColorBlend> COLOR_BLEND = new GroupBuilder<ColorBlend>().name("ColorBlend").concrete(true).addFeatures(ColorBlend.Features.ALL).lmBuilder(new BuilderSupplier<>(ColorBlendBuilder::new)).build();
    Group<ColorBlendAttachment> COLOR_BLEND_ATTACHMENT = new GroupBuilder<ColorBlendAttachment>().name("ColorBlendAttachment").concrete(true).addFeatures(ColorBlendAttachment.Features.ALL).lmBuilder(new BuilderSupplier<>(ColorBlendAttachmentBuilder::new)).build();
    Group<InputAssembly> INPUT_ASSEMBLY = new GroupBuilder<InputAssembly>().name("InputAssembly").concrete(true).addFeatures(InputAssembly.Features.ALL).lmBuilder(new BuilderSupplier<>(InputAssemblyBuilder::new)).build();
    Group<Rasterizer> RASTERIZER = new GroupBuilder<Rasterizer>().name("Rasterizer").concrete(true).addFeatures(Rasterizer.Features.ALL).lmBuilder(new BuilderSupplier<>(RasterizerBuilder::new)).build();
    Group<DynamicState> DYNAMIC_STATE = new GroupBuilder<DynamicState>().name("DynamicState").concrete(true).addFeatures(DynamicState.Features.ALL).lmBuilder(new BuilderSupplier<>(DynamicStateBuilder::new)).build();
    Group<ViewportState> VIEWPORT_STATE = new GroupBuilder<ViewportState>().name("ViewportState").addFeatures(ViewportState.Features.ALL).build();
    Group<StaticViewportState> STATIC_VIEWPORT_STATE = new GroupBuilder<StaticViewportState>().name("StaticViewportState").concrete(true).addInclude(() -> new IncludeBuilder<ViewportState>().group(() -> VIEWPORT_STATE).build()).addFeatures(StaticViewportState.Features.ALL).lmBuilder(new BuilderSupplier<>(StaticViewportStateBuilder::new)).build();
    Group<DynamicViewportState> DYNAMIC_VIEWPORT_STATE = new GroupBuilder<DynamicViewportState>().name("DynamicViewportState").concrete(true).addInclude(() -> new IncludeBuilder<ViewportState>().group(() -> VIEWPORT_STATE).build()).addFeatures(DynamicViewportState.Features.ALL).lmBuilder(new BuilderSupplier<>(DynamicViewportStateBuilder::new)).build();
    Group<IViewport> I_VIEWPORT = new GroupBuilder<IViewport>().name("IViewport").addFeatures(IViewport.Features.ALL).build();
    Group<Viewport> VIEWPORT = new GroupBuilder<Viewport>().name("Viewport").concrete(true).addInclude(() -> new IncludeBuilder<IViewport>().group(() -> I_VIEWPORT).build()).addFeatures(Viewport.Features.ALL).lmBuilder(new BuilderSupplier<>(ViewportBuilder::new)).build();
    Group<CinemaViewport> CINEMA_VIEWPORT = new GroupBuilder<CinemaViewport>().name("CinemaViewport").concrete(true).addInclude(() -> new IncludeBuilder<IViewport>().group(() -> I_VIEWPORT).build()).addFeatures(CinemaViewport.Features.ALL).lmBuilder(new BuilderSupplier<>(CinemaViewportBuilder::new)).build();
    Group<Scissor> SCISSOR = new GroupBuilder<Scissor>().name("Scissor").concrete(true).addFeatures(Scissor.Features.ALL).lmBuilder(new BuilderSupplier<>(ScissorBuilder::new)).build();
    Group<DepthStencilState> DEPTH_STENCIL_STATE = new GroupBuilder<DepthStencilState>().name("DepthStencilState").concrete(true).addFeatures(DepthStencilState.Features.ALL).lmBuilder(new BuilderSupplier<>(DepthStencilStateBuilder::new)).build();
    List<Group<?>> ALL = List.of(COLOR_BLEND, COLOR_BLEND_ATTACHMENT, INPUT_ASSEMBLY, RASTERIZER, DYNAMIC_STATE, VIEWPORT_STATE, STATIC_VIEWPORT_STATE, DYNAMIC_VIEWPORT_STATE, I_VIEWPORT, VIEWPORT, CINEMA_VIEWPORT, SCISSOR, DEPTH_STENCIL_STATE);
  }

  interface Units {
    List<Unit<?>> ALL = List.of();
  }

  interface Enums {
    List<Enum<?>> ALL = List.of();
  }

  interface Aliases {
    List<Alias> ALL = List.of();
  }

  interface JavaWrappers {
    List<JavaWrapper<?>> ALL = List.of();
  }
}
