package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.ColorDomain;
import org.sheepy.lily.vulkan.model.process.graphic.PhysicalSurface;
import org.sheepy.lily.vulkan.model.process.graphic.PhysicalSurface.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.PhysicalSurfaceImpl;

public final class PhysicalSurfaceBuilder implements Builder {
  private Supplier<ColorDomain> colorDomain;

  public PhysicalSurfaceBuilder() {
  }

  @Override
  public PhysicalSurfaceBuilder colorDomain(Supplier<ColorDomain> colorDomain) {
    this.colorDomain = colorDomain;
    return this;
  }

  @Override
  public PhysicalSurface build() {
    final var built = new PhysicalSurfaceImpl(colorDomain.get());
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
    private static final FeatureInserter<PhysicalSurfaceBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<PhysicalSurfaceBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<PhysicalSurfaceBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<PhysicalSurfaceBuilder>(1, Inserters::relationIndex).add(PhysicalSurface.FeatureIDs.COLOR_DOMAIN, (builder, value) -> builder.colorDomain((Supplier<ColorDomain>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case PhysicalSurface.FeatureIDs.COLOR_DOMAIN -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
