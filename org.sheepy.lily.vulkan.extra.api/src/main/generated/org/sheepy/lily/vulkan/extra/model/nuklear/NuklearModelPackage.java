package org.sheepy.lily.vulkan.extra.model.nuklear;

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

public final class NuklearModelPackage implements IModelPackage {
  public static final NuklearModelPackage Instance = new NuklearModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Nuklear").domain("org.sheepy.lily.vulkan.extra.model").addImports(List.of("org.sheepy.lily.vulkan.model.Process", "org.sheepy.lily.vulkan.model.Vulkan", "org.sheepy.lily.vulkan.model.VulkanResource", "org.sheepy.lily.core.model.UI", "org.sheepy.lily.core.model.Variable")).genNamePackage(true).lmPackage(Instance).addGroups(NuklearModelDefinition.Groups.ALL).addEnums(NuklearModelDefinition.Enums.ALL).addUnits(NuklearModelDefinition.Units.ALL).addAliases(NuklearModelDefinition.Aliases.ALL).addJavaWrappers(NuklearModelDefinition.JavaWrappers.ALL).build();

  private NuklearModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == NuklearModelDefinition.Groups.NUKLEAR_PUSH_CONSTANTS) return Optional.of((IFeaturedObject.Builder<T>) NuklearPushConstants.builder());
    else if (group == NuklearModelDefinition.Groups.NUKLEAR_CONTEXT) return Optional.of((IFeaturedObject.Builder<T>) NuklearContext.builder());
    else if (group == NuklearModelDefinition.Groups.NUKLEAR_FONT) return Optional.of((IFeaturedObject.Builder<T>) NuklearFont.builder());
    else if (group == NuklearModelDefinition.Groups.SELECTOR_PANEL) return Optional.of((IFeaturedObject.Builder<T>) SelectorPanel.builder());
    else if (group == NuklearModelDefinition.Groups.PANEL_VIEWER) return Optional.of((IFeaturedObject.Builder<T>) PanelViewer.builder());
    else if (group == NuklearModelDefinition.Groups.FONT_IMAGE_PROVIDER) return Optional.of((IFeaturedObject.Builder<T>) FontImageProvider.builder());
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
