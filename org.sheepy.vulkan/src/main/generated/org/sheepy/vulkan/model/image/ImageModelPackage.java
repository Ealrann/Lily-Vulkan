package org.sheepy.vulkan.model.image;

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

public final class ImageModelPackage implements IModelPackage {
  public static final ImageModelPackage Instance = new ImageModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Image").domain("org.sheepy.vulkan.model").addImports(List.of("org.sheepy.vulkan.model.Enumeration")).genNamePackage(true).lmPackage(Instance).addGroups(ImageModelDefinition.Groups.ALL).addEnums(ImageModelDefinition.Enums.ALL).addUnits(ImageModelDefinition.Units.ALL).addAliases(ImageModelDefinition.Aliases.ALL).addJavaWrappers(ImageModelDefinition.JavaWrappers.ALL).build();

  private ImageModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == ImageModelDefinition.Groups.SAMPLER_INFO) return Optional.of((IFeaturedObject.Builder<T>) SamplerInfo.builder());
    else if (group == ImageModelDefinition.Groups.IMAGE_INFO) return Optional.of((IFeaturedObject.Builder<T>) ImageInfo.builder());
    else if (group == ImageModelDefinition.Groups.IMAGE_LAYOUT) return Optional.of((IFeaturedObject.Builder<T>) ImageLayout.builder());
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
