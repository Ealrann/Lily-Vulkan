package org.sheepy.lily.vulkan.extra.model.shape;

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

public final class ShapeModelPackage implements IModelPackage {
  public static final ShapeModelPackage Instance = new ShapeModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("Shape").domain("org.sheepy.lily.vulkan.extra.model").addImports(List.of("org.sheepy.lily.vulkan.extra.model.Mesh")).genNamePackage(true).lmPackage(Instance).addGroups(ShapeModelDefinition.Groups.ALL).addEnums(ShapeModelDefinition.Enums.ALL).addUnits(ShapeModelDefinition.Units.ALL).addAliases(ShapeModelDefinition.Aliases.ALL).addJavaWrappers(ShapeModelDefinition.JavaWrappers.ALL).build();

  private ShapeModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == ShapeModelDefinition.Groups.GEOMETRIC_MESH) return Optional.of((IFeaturedObject.Builder<T>) GeometricMesh.builder());
    else if (group == ShapeModelDefinition.Groups.ICOSAHEDRON) return Optional.of((IFeaturedObject.Builder<T>) Icosahedron.builder());
    else if (group == ShapeModelDefinition.Groups.SPHERE) return Optional.of((IFeaturedObject.Builder<T>) Sphere.builder());
    else if (group == ShapeModelDefinition.Groups.ICO_SPHERE) return Optional.of((IFeaturedObject.Builder<T>) IcoSphere.builder());
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
