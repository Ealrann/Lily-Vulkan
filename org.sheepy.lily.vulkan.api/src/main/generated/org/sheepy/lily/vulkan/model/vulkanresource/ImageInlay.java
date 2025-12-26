package org.sheepy.lily.vulkan.model.vulkanresource;

import java.util.List;
import java.util.function.Supplier;
import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.FloatListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.ImageInlayBuilder;

public interface ImageInlay extends LMObject {
  static Builder builder() {
    return new ImageInlayBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  IVulkanImage image();
  Vector2ic position();
  float size();
  EHorizontalRelative horizontalRelative();
  EVerticalRelative verticalRelative();
  void image(final IVulkanImage image);
  void position(final Vector2ic position);
  void size(final float size);
  void horizontalRelative(final EHorizontalRelative horizontalRelative);
  void verticalRelative(final EVerticalRelative verticalRelative);

  interface FeatureIDs {
    int IMAGE = -1264602032;
    int POSITION = -993481196;
    int SIZE = -1980161428;
    int HORIZONTAL_RELATIVE = -814435781;
    int VERTICAL_RELATIVE = 1181936205;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<IVulkanImage, IVulkanImage, Listener<IVulkanImage>, Features<?>> IMAGE = new RelationBuilder<IVulkanImage, IVulkanImage, Listener<IVulkanImage>, Features<?>>().name("image").mandatory(true).id(ImageInlay.FeatureIDs.IMAGE).concept(() -> VulkanResourceModelDefinition.Groups.I_VULKAN_IMAGE).build();
    Attribute<Vector2ic, Vector2ic, Listener<Vector2ic>, Features<?>> POSITION = new AttributeBuilder<Vector2ic, Vector2ic, Listener<Vector2ic>, Features<?>>().name("position").mandatory(true).defaultValue("0;0").id(ImageInlay.FeatureIDs.POSITION).datatype(() -> TypesModelDefinition.JavaWrappers.VECTOR2I).build();
    Attribute<Float, Float, FloatListener, Features<?>> SIZE = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("size").mandatory(true).defaultValue("1f").id(ImageInlay.FeatureIDs.SIZE).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    Attribute<EHorizontalRelative, EHorizontalRelative, Listener<EHorizontalRelative>, Features<?>> HORIZONTAL_RELATIVE = new AttributeBuilder<EHorizontalRelative, EHorizontalRelative, Listener<EHorizontalRelative>, Features<?>>().name("horizontalRelative").mandatory(true).defaultValue("LEFT").id(ImageInlay.FeatureIDs.HORIZONTAL_RELATIVE).datatype(() -> TypesModelDefinition.Enums.E_HORIZONTAL_RELATIVE).build();
    Attribute<EVerticalRelative, EVerticalRelative, Listener<EVerticalRelative>, Features<?>> VERTICAL_RELATIVE = new AttributeBuilder<EVerticalRelative, EVerticalRelative, Listener<EVerticalRelative>, Features<?>>().name("verticalRelative").mandatory(true).defaultValue("TOP").id(ImageInlay.FeatureIDs.VERTICAL_RELATIVE).datatype(() -> TypesModelDefinition.Enums.E_VERTICAL_RELATIVE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(IMAGE, POSITION, SIZE, HORIZONTAL_RELATIVE, VERTICAL_RELATIVE);
  }

  interface Builder extends IFeaturedObject.Builder<ImageInlay> {
    Builder image(Supplier<IVulkanImage> image);
    Builder position(Vector2ic position);
    Builder size(float size);
    Builder horizontalRelative(EHorizontalRelative horizontalRelative);
    Builder verticalRelative(EVerticalRelative verticalRelative);
  }
}
