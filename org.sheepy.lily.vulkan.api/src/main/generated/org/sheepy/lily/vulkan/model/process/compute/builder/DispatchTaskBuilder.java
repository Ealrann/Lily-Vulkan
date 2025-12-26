package org.sheepy.lily.vulkan.model.process.compute.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.compute.DispatchTask;
import org.sheepy.lily.vulkan.model.process.compute.DispatchTask.Builder;
import org.sheepy.lily.vulkan.model.process.compute.impl.DispatchTaskImpl;

public final class DispatchTaskBuilder implements Builder {
  private String name;
  private boolean enabled = true;
  private int workgroupCountX = 1;
  private int workgroupCountY = 1;
  private int workgroupCountZ = 1;

  public DispatchTaskBuilder() {
  }

  @Override
  public DispatchTaskBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public DispatchTaskBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public DispatchTaskBuilder workgroupCountX(int workgroupCountX) {
    this.workgroupCountX = workgroupCountX;
    return this;
  }

  @Override
  public DispatchTaskBuilder workgroupCountY(int workgroupCountY) {
    this.workgroupCountY = workgroupCountY;
    return this;
  }

  @Override
  public DispatchTaskBuilder workgroupCountZ(int workgroupCountZ) {
    this.workgroupCountZ = workgroupCountZ;
    return this;
  }

  @Override
  public DispatchTask build() {
    final var built = new DispatchTaskImpl(name);
    built.enabled(enabled);
    built.workgroupCountX(workgroupCountX);
    built.workgroupCountY(workgroupCountY);
    built.workgroupCountZ(workgroupCountZ);
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
    private static final FeatureInserter<DispatchTaskBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<DispatchTaskBuilder>(5, Inserters::attributeIndex).add(DispatchTask.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(DispatchTask.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).add(DispatchTask.FeatureIDs.WORKGROUP_COUNTX, (builder, value) -> builder.workgroupCountX((int) value)).add(DispatchTask.FeatureIDs.WORKGROUP_COUNTY, (builder, value) -> builder.workgroupCountY((int) value)).add(DispatchTask.FeatureIDs.WORKGROUP_COUNTZ, (builder, value) -> builder.workgroupCountZ((int) value)).build();
    private static final RelationLazyInserter<DispatchTaskBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<DispatchTaskBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case DispatchTask.FeatureIDs.NAME -> 0;
        case DispatchTask.FeatureIDs.ENABLED -> 1;
        case DispatchTask.FeatureIDs.WORKGROUP_COUNTX -> 2;
        case DispatchTask.FeatureIDs.WORKGROUP_COUNTY -> 3;
        case DispatchTask.FeatureIDs.WORKGROUP_COUNTZ -> 4;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
