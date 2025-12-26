package org.sheepy.lily.vulkan.extra.model.rendering.builder;

import java.nio.ByteBuffer;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.rendering.MousePickConstants;
import org.sheepy.lily.vulkan.extra.model.rendering.MousePickConstants.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.MousePickConstantsImpl;

public final class MousePickConstantsBuilder implements Builder {
  private String name;
  private ByteBuffer data;
  private Supplier<MousePickExtension> mousePickExtension;

  public MousePickConstantsBuilder() {
  }

  @Override
  public MousePickConstantsBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public MousePickConstantsBuilder data(ByteBuffer data) {
    this.data = data;
    return this;
  }

  @Override
  public MousePickConstantsBuilder mousePickExtension(
      Supplier<MousePickExtension> mousePickExtension) {
    this.mousePickExtension = mousePickExtension;
    return this;
  }

  @Override
  public MousePickConstants build() {
    final var built = new MousePickConstantsImpl(name, mousePickExtension.get());
    built.data(data);
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
    private static final FeatureInserter<MousePickConstantsBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<MousePickConstantsBuilder>(2, Inserters::attributeIndex).add(MousePickConstants.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(MousePickConstants.FeatureIDs.DATA, (builder, value) -> builder.data((ByteBuffer) value)).build();
    private static final RelationLazyInserter<MousePickConstantsBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<MousePickConstantsBuilder>(1, Inserters::relationIndex).add(MousePickConstants.FeatureIDs.MOUSE_PICK_EXTENSION, (builder, value) -> builder.mousePickExtension((Supplier<MousePickExtension>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case MousePickConstants.FeatureIDs.NAME -> 0;
        case MousePickConstants.FeatureIDs.DATA -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case MousePickConstants.FeatureIDs.MOUSE_PICK_EXTENSION -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
