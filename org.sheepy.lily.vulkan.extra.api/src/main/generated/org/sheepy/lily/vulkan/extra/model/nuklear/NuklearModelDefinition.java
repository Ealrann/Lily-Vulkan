package org.sheepy.lily.vulkan.extra.model.nuklear;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.sheepy.lily.core.model.ui.IPanel;
import org.sheepy.lily.core.model.ui.Panel;
import org.sheepy.lily.core.model.ui.UIModelDefinition;
import org.sheepy.lily.vulkan.extra.model.nuklear.builder.FontImageProviderBuilder;
import org.sheepy.lily.vulkan.extra.model.nuklear.builder.NuklearContextBuilder;
import org.sheepy.lily.vulkan.extra.model.nuklear.builder.NuklearFontBuilder;
import org.sheepy.lily.vulkan.extra.model.nuklear.builder.NuklearPushConstantsBuilder;
import org.sheepy.lily.vulkan.extra.model.nuklear.builder.PanelViewerBuilder;
import org.sheepy.lily.vulkan.extra.model.nuklear.builder.SelectorPanelBuilder;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.lily.vulkan.model.process.PushConstant;
import org.sheepy.lily.vulkan.model.vulkan.IVulkanResource;
import org.sheepy.lily.vulkan.model.vulkan.VulkanModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDataProvider;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public interface NuklearModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<NuklearPushConstants> NUKLEAR_PUSH_CONSTANTS = new GroupBuilder<NuklearPushConstants>().name("NuklearPushConstants").concrete(true).addInclude(() -> new IncludeBuilder<PushConstant>().group(() -> ProcessModelDefinition.Groups.PUSH_CONSTANT).build()).addFeatures(NuklearPushConstants.Features.ALL).lmBuilder(new BuilderSupplier<>(NuklearPushConstantsBuilder::new)).build();
    Group<NuklearContext> NUKLEAR_CONTEXT = new GroupBuilder<NuklearContext>().name("NuklearContext").concrete(true).addInclude(() -> new IncludeBuilder<IVulkanResource>().group(() -> VulkanModelDefinition.Groups.I_VULKAN_RESOURCE).build()).addFeatures(NuklearContext.Features.ALL).lmBuilder(new BuilderSupplier<>(NuklearContextBuilder::new)).build();
    Group<NuklearFont> NUKLEAR_FONT = new GroupBuilder<NuklearFont>().name("NuklearFont").concrete(true).addInclude(() -> new IncludeBuilder<IVulkanResource>().group(() -> VulkanModelDefinition.Groups.I_VULKAN_RESOURCE).build()).addFeatures(NuklearFont.Features.ALL).lmBuilder(new BuilderSupplier<>(NuklearFontBuilder::new)).build();
    Group<SelectorPanel> SELECTOR_PANEL = new GroupBuilder<SelectorPanel>().name("SelectorPanel").concrete(true).addInclude(() -> new IncludeBuilder<IPanel>().group(() -> UIModelDefinition.Groups.I_PANEL).build()).addFeatures(SelectorPanel.Features.ALL).lmBuilder(new BuilderSupplier<>(SelectorPanelBuilder::new)).build();
    Group<IInputProvider> I_INPUT_PROVIDER = new GroupBuilder<IInputProvider>().name("IInputProvider").addFeatures(IInputProvider.Features.ALL).build();
    Group<PanelViewer> PANEL_VIEWER = new GroupBuilder<PanelViewer>().name("PanelViewer").concrete(true).addInclude(() -> new IncludeBuilder<Panel>().group(() -> UIModelDefinition.Groups.PANEL).build()).addFeatures(PanelViewer.Features.ALL).lmBuilder(new BuilderSupplier<>(PanelViewerBuilder::new)).build();
    Group<FontImageProvider> FONT_IMAGE_PROVIDER = new GroupBuilder<FontImageProvider>().name("FontImageProvider").concrete(true).addInclude(() -> new IncludeBuilder<ImageDataProvider>().group(() -> VulkanResourceModelDefinition.Groups.IMAGE_DATA_PROVIDER).build()).addFeatures(FontImageProvider.Features.ALL).lmBuilder(new BuilderSupplier<>(FontImageProviderBuilder::new)).build();
    List<Group<?>> ALL = List.of(NUKLEAR_PUSH_CONSTANTS, NUKLEAR_CONTEXT, NUKLEAR_FONT, SELECTOR_PANEL, I_INPUT_PROVIDER, PANEL_VIEWER, FONT_IMAGE_PROVIDER);
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
