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
import org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor;
import org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptorsProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptorsProvider.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.DataDescriptorsProviderImpl;

public final class DataDescriptorsProviderBuilder implements Builder {
  private final List<Supplier<DataDescriptor>> dataDescriptors = new ArrayList<>();

  public DataDescriptorsProviderBuilder() {
  }

  @Override
  public DataDescriptorsProviderBuilder addDataDescriptor(Supplier<DataDescriptor> dataDescriptor) {
    this.dataDescriptors.add(dataDescriptor);
    return this;
  }

  @Override
  public DataDescriptorsProviderBuilder addDataDescriptors(
      final List<DataDescriptor> dataDescriptors) {
    dataDescriptors.forEach(value -> this.dataDescriptors.add(() -> value));
    return this;
  }

  @Override
  public DataDescriptorsProvider build() {
    final var builtDataDescriptors = BuildUtils.collectSuppliers(dataDescriptors);
    final var built = new DataDescriptorsProviderImpl(builtDataDescriptors);
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
    private static final FeatureInserter<DataDescriptorsProviderBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<DataDescriptorsProviderBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<DataDescriptorsProviderBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<DataDescriptorsProviderBuilder>(1, Inserters::relationIndex).add(DataDescriptorsProvider.FeatureIDs.DATA_DESCRIPTORS, (builder, value) -> builder.addDataDescriptor((Supplier<DataDescriptor>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case DataDescriptorsProvider.FeatureIDs.DATA_DESCRIPTORS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
