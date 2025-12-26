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
import org.sheepy.lily.vulkan.extra.model.rendering.DataProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.DataProviderPkgImpl;

public final class DataProviderPkgBuilder<T extends Structure> implements Builder<T> {
  private final List<Supplier<DataProvider<T>>> dataProviders = new ArrayList<>();

  public DataProviderPkgBuilder() {
  }

  @Override
  public DataProviderPkgBuilder<T> addDataProvider(Supplier<DataProvider<T>> dataProvider) {
    this.dataProviders.add(dataProvider);
    return this;
  }

  @SuppressWarnings({
      "unchecked",
      "rawtypes"
  })
  private DataProviderPkgBuilder<T> _dataProviders(final Supplier<DataProvider<?>> dataProvider) {
    this.dataProviders.add((Supplier) dataProvider);
    return this;
  }

  @Override
  public DataProviderPkgBuilder<T> addDataProviders(final List<DataProvider<?>> dataProviders) {
    dataProviders.forEach(value -> this._dataProviders(() -> value));
    return this;
  }

  @Override
  public DataProviderPkg<T> build() {
    final var builtDataProviders = BuildUtils.collectSuppliers(dataProviders);
    final var built = new DataProviderPkgImpl<T>(builtDataProviders);
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
    private static final FeatureInserter<DataProviderPkgBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<DataProviderPkgBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<DataProviderPkgBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<DataProviderPkgBuilder>(1, Inserters::relationIndex).add(DataProviderPkg.FeatureIDs.DATA_PROVIDERS, (builder, value) -> builder._dataProviders((Supplier<DataProvider<?>>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case DataProviderPkg.FeatureIDs.DATA_PROVIDERS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
