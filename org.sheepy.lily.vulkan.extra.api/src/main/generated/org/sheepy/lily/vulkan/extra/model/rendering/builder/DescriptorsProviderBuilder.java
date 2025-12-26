package org.sheepy.lily.vulkan.extra.model.rendering.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.extra.model.rendering.DescriptorsProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.DescriptorsProvider.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.DescriptorsProviderImpl;
import org.sheepy.lily.vulkan.model.vulkan.IDescriptor;

public final class DescriptorsProviderBuilder implements Builder {
  private final List<Supplier<IDescriptor>> descriptors = new ArrayList<>();

  public DescriptorsProviderBuilder() {
  }

  @Override
  public DescriptorsProviderBuilder addDescriptor(Supplier<IDescriptor> descriptor) {
    this.descriptors.add(descriptor);
    return this;
  }

  @Override
  public DescriptorsProviderBuilder addDescriptors(final List<IDescriptor> descriptors) {
    descriptors.forEach(value -> this.descriptors.add(() -> value));
    return this;
  }

  @Override
  public DescriptorsProvider build() {
    final var builtDescriptors = BuildUtils.collectSuppliers(descriptors);
    final var built = new DescriptorsProviderImpl(builtDescriptors);
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
    private static final FeatureInserter<DescriptorsProviderBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<DescriptorsProviderBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<DescriptorsProviderBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<DescriptorsProviderBuilder>(1, Inserters::relationIndex).add(DescriptorsProvider.FeatureIDs.DESCRIPTORS, (builder, value) -> builder.addDescriptor((Supplier<IDescriptor>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case DescriptorsProvider.FeatureIDs.DESCRIPTORS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
