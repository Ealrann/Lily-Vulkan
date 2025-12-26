package org.sheepy.vulkan.model.image.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.image.ImageLayout;
import org.sheepy.vulkan.model.image.ImageLayout.Builder;
import org.sheepy.vulkan.model.image.impl.ImageLayoutImpl;

public final class ImageLayoutBuilder implements Builder {
  private EPipelineStage stage = EPipelineStage.TOP_OF_PIPE_BIT;
  private EImageLayout layout = EImageLayout.SHADER_READ_ONLY_OPTIMAL;
  private final List<EAccess> accessMask = new ArrayList<>();

  public ImageLayoutBuilder() {
  }

  @Override
  public ImageLayoutBuilder stage(EPipelineStage stage) {
    this.stage = stage;
    return this;
  }

  @Override
  public ImageLayoutBuilder layout(EImageLayout layout) {
    this.layout = layout;
    return this;
  }

  @Override
  public ImageLayoutBuilder addAccessMask(EAccess accessMask) {
    this.accessMask.add(accessMask);
    return this;
  }

  @Override
  public ImageLayoutBuilder addAccessMask(final List<EAccess> accessMask) {
    this.accessMask.addAll(accessMask);
    return this;
  }

  @Override
  public ImageLayout build() {
    final var built = new ImageLayoutImpl();
    built.stage(stage);
    built.layout(layout);
    built.accessMask().addAll(accessMask);
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
    private static final FeatureInserter<ImageLayoutBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ImageLayoutBuilder>(3, Inserters::attributeIndex).add(ImageLayout.FeatureIDs.STAGE, (builder, value) -> builder.stage((EPipelineStage) value)).add(ImageLayout.FeatureIDs.LAYOUT, (builder, value) -> builder.layout((EImageLayout) value)).add(ImageLayout.FeatureIDs.ACCESS_MASK, (builder, value) -> builder.addAccessMask((EAccess) value)).build();
    private static final RelationLazyInserter<ImageLayoutBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ImageLayoutBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ImageLayout.FeatureIDs.STAGE -> 0;
        case ImageLayout.FeatureIDs.LAYOUT -> 1;
        case ImageLayout.FeatureIDs.ACCESS_MASK -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
