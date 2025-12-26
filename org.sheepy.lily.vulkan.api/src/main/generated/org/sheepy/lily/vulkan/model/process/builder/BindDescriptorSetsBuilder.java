package org.sheepy.lily.vulkan.model.process.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.model.process.BindDescriptorSets;
import org.sheepy.lily.vulkan.model.process.BindDescriptorSets.Builder;
import org.sheepy.lily.vulkan.model.process.impl.BindDescriptorSetsImpl;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.vulkan.model.enumeration.EBindPoint;

public final class BindDescriptorSetsBuilder implements Builder {
  private String name;
  private boolean enabled = true;
  private final List<Supplier<DescriptorSet>> descriptorSets = new ArrayList<>();
  private EBindPoint bindPoint = EBindPoint.GRAPHICS;
  private int stride = 0;

  public BindDescriptorSetsBuilder() {
  }

  @Override
  public BindDescriptorSetsBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public BindDescriptorSetsBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public BindDescriptorSetsBuilder addDescriptorSet(Supplier<DescriptorSet> descriptorSet) {
    this.descriptorSets.add(descriptorSet);
    return this;
  }

  @Override
  public BindDescriptorSetsBuilder addDescriptorSets(final List<DescriptorSet> descriptorSets) {
    descriptorSets.forEach(value -> this.descriptorSets.add(() -> value));
    return this;
  }

  @Override
  public BindDescriptorSetsBuilder bindPoint(EBindPoint bindPoint) {
    this.bindPoint = bindPoint;
    return this;
  }

  @Override
  public BindDescriptorSetsBuilder stride(int stride) {
    this.stride = stride;
    return this;
  }

  @Override
  public BindDescriptorSets build() {
    final var builtDescriptorSets = BuildUtils.collectSuppliers(descriptorSets);
    final var built = new BindDescriptorSetsImpl(name, bindPoint);
    built.enabled(enabled);
    built.descriptorSets().addAll(builtDescriptorSets);
    built.stride(stride);
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
    private static final FeatureInserter<BindDescriptorSetsBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<BindDescriptorSetsBuilder>(4, Inserters::attributeIndex).add(BindDescriptorSets.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(BindDescriptorSets.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).add(BindDescriptorSets.FeatureIDs.BIND_POINT, (builder, value) -> builder.bindPoint((EBindPoint) value)).add(BindDescriptorSets.FeatureIDs.STRIDE, (builder, value) -> builder.stride((int) value)).build();
    private static final RelationLazyInserter<BindDescriptorSetsBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<BindDescriptorSetsBuilder>(1, Inserters::relationIndex).add(BindDescriptorSets.FeatureIDs.DESCRIPTOR_SETS, (builder, value) -> builder.addDescriptorSet((Supplier<DescriptorSet>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case BindDescriptorSets.FeatureIDs.NAME -> 0;
        case BindDescriptorSets.FeatureIDs.ENABLED -> 1;
        case BindDescriptorSets.FeatureIDs.BIND_POINT -> 2;
        case BindDescriptorSets.FeatureIDs.STRIDE -> 3;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case BindDescriptorSets.FeatureIDs.DESCRIPTOR_SETS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
