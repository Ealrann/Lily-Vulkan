package org.sheepy.lily.vulkan.extra.model.sprite;

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

public final class SpriteModelPackage implements IModelPackage {
  public static final SpriteModelPackage Instance = new SpriteModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Sprite").domain("org.sheepy.lily.vulkan.extra.model").addImports(List.of("org.sheepy.lily.core.model.Presentation", "org.sheepy.lily.core.model.Resource", "org.sheepy.lily.core.model.Types", "org.sheepy.lily.vulkan.extra.model.Rendering", "org.sheepy.lily.vulkan.model.process.Graphic", "org.sheepy.lily.vulkan.model.Process", "org.sheepy.lily.vulkan.model.VulkanResource")).genNamePackage(true).lmPackage(Instance).addGroups(SpriteModelDefinition.Groups.ALL).addEnums(SpriteModelDefinition.Enums.ALL).addUnits(SpriteModelDefinition.Units.ALL).addAliases(SpriteModelDefinition.Aliases.ALL).addJavaWrappers(SpriteModelDefinition.JavaWrappers.ALL).build();

  private SpriteModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == SpriteModelDefinition.Groups.SPRITE_EXTENSION) return Optional.of((IFeaturedObject.Builder<T>) SpriteExtension.builder());
    else if (group == SpriteModelDefinition.Groups.SPRITE_PKG) return Optional.of((IFeaturedObject.Builder<T>) SpritePkg.builder());
    else if (group == SpriteModelDefinition.Groups.SPRITE) return Optional.of((IFeaturedObject.Builder<T>) Sprite.builder());
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
