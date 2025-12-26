package org.sheepy.lily.vulkan.extra.model.rendering.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.rendering.EPhysicalEntityFeature;
import org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable;
import org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.PhysicalEntityVariableImpl;

public final class PhysicalEntityVariableBuilder implements Builder {
  private String name;
  private Supplier<PhysicalEntity> entity = () -> null;
  private EPhysicalEntityFeature feature = EPhysicalEntityFeature.Location;

  public PhysicalEntityVariableBuilder() {
  }

  @Override
  public PhysicalEntityVariableBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public PhysicalEntityVariableBuilder entity(Supplier<PhysicalEntity> entity) {
    this.entity = entity;
    return this;
  }

  @Override
  public PhysicalEntityVariableBuilder feature(EPhysicalEntityFeature feature) {
    this.feature = feature;
    return this;
  }

  @Override
  public PhysicalEntityVariable build() {
    final var built = new PhysicalEntityVariableImpl(name, feature);
    built.entity(entity.get());
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
    private static final FeatureInserter<PhysicalEntityVariableBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<PhysicalEntityVariableBuilder>(2, Inserters::attributeIndex).add(PhysicalEntityVariable.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(PhysicalEntityVariable.FeatureIDs.FEATURE, (builder, value) -> builder.feature((EPhysicalEntityFeature) value)).build();
    private static final RelationLazyInserter<PhysicalEntityVariableBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<PhysicalEntityVariableBuilder>(1, Inserters::relationIndex).add(PhysicalEntityVariable.FeatureIDs.ENTITY, (builder, value) -> builder.entity((Supplier<PhysicalEntity>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case PhysicalEntityVariable.FeatureIDs.NAME -> 0;
        case PhysicalEntityVariable.FeatureIDs.FEATURE -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case PhysicalEntityVariable.FeatureIDs.ENTITY -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
