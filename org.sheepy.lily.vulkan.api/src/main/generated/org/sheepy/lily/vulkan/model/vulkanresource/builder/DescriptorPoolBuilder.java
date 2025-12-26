package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.DescriptorPoolImpl;

public final class DescriptorPoolBuilder implements Builder {
  private final List<Supplier<DescriptorSet>> descriptorSets = new ArrayList<>();

  public DescriptorPoolBuilder() {
  }

  @Override
  public DescriptorPoolBuilder addDescriptorSet(Supplier<DescriptorSet> descriptorSet) {
    this.descriptorSets.add(descriptorSet);
    return this;
  }

  @Override
  public DescriptorPoolBuilder addDescriptorSets(final List<DescriptorSet> descriptorSets) {
    descriptorSets.forEach(value -> this.descriptorSets.add(() -> value));
    return this;
  }

  @Override
  public DescriptorPool build() {
    final var builtDescriptorSets = BuildUtils.collectSuppliers(descriptorSets);
    final var built = new DescriptorPoolImpl();
    built.descriptorSets().addAll(builtDescriptorSets);
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
    private static final FeatureInserter<DescriptorPoolBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<DescriptorPoolBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<DescriptorPoolBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<DescriptorPoolBuilder>(1, Inserters::relationIndex).add(DescriptorPool.FeatureIDs.DESCRIPTOR_SETS, (builder, value) -> builder.addDescriptorSet((Supplier<DescriptorSet>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case DescriptorPool.FeatureIDs.DESCRIPTOR_SETS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
