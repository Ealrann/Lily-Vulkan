package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.util.function.Function;
import java.util.function.Supplier;
import org.joml.Vector2ic;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.types.EHorizontalRelative;
import org.sheepy.lily.core.model.types.EVerticalRelative;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageInlay.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageInlayImpl;

public final class ImageInlayBuilder implements Builder {
  private Supplier<IVulkanImage> image;
  private Vector2ic position = ((Function<String, Vector2ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==2){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);return new org.joml.Vector2i(x,y);}}return new org.joml.Vector2i(0,0); }).apply("0;0");
  private float size = 1f;
  private EHorizontalRelative horizontalRelative = EHorizontalRelative.LEFT;
  private EVerticalRelative verticalRelative = EVerticalRelative.TOP;

  public ImageInlayBuilder() {
  }

  @Override
  public ImageInlayBuilder image(Supplier<IVulkanImage> image) {
    this.image = image;
    return this;
  }

  @Override
  public ImageInlayBuilder position(Vector2ic position) {
    this.position = position;
    return this;
  }

  @Override
  public ImageInlayBuilder size(float size) {
    this.size = size;
    return this;
  }

  @Override
  public ImageInlayBuilder horizontalRelative(EHorizontalRelative horizontalRelative) {
    this.horizontalRelative = horizontalRelative;
    return this;
  }

  @Override
  public ImageInlayBuilder verticalRelative(EVerticalRelative verticalRelative) {
    this.verticalRelative = verticalRelative;
    return this;
  }

  @Override
  public ImageInlay build() {
    final var built = new ImageInlayImpl(image.get(), position, size, horizontalRelative, verticalRelative);
    return built;
  }

  @Override
  public <AttributeType> void push(final Attribute<?, ?, ?, ?> attribute,
      final AttributeType value) {
    Inserters.ATTRIBUTE_INSERTER.push(this, attribute.id(), value);
  }

  @Override
  public <RelationType extends LMObject> void push(final Relation<RelationType, ?, ?, ?> relation,
      final Supplier<RelationType> supplier) {
    Inserters.RELATION_INSERTER.push(this, relation.id(), supplier);
  }

  private static final class Inserters {
    private static final FeatureInserter<ImageInlayBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ImageInlayBuilder>(4, Inserters::attributeIndex).add(ImageInlay.FeatureIDs.POSITION, (builder, value) -> builder.position((Vector2ic) value)).add(ImageInlay.FeatureIDs.SIZE, (builder, value) -> builder.size((float) value)).add(ImageInlay.FeatureIDs.HORIZONTAL_RELATIVE, (builder, value) -> builder.horizontalRelative((EHorizontalRelative) value)).add(ImageInlay.FeatureIDs.VERTICAL_RELATIVE, (builder, value) -> builder.verticalRelative((EVerticalRelative) value)).build();
    private static final RelationLazyInserter<ImageInlayBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ImageInlayBuilder>(1, Inserters::relationIndex).add(ImageInlay.FeatureIDs.IMAGE, (builder, value) -> builder.image((Supplier<IVulkanImage>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ImageInlay.FeatureIDs.POSITION -> 0;
        case ImageInlay.FeatureIDs.SIZE -> 1;
        case ImageInlay.FeatureIDs.HORIZONTAL_RELATIVE -> 2;
        case ImageInlay.FeatureIDs.VERTICAL_RELATIVE -> 3;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case ImageInlay.FeatureIDs.IMAGE -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
