package org.sheepy.lily.vulkan.extra.model.rendering.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderableDataSourceImpl;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;

public final class RenderableDataSourceBuilder<T extends Structure> implements Builder<T> {
  private String name;
  private Supplier<T> structure;
  private int part;
  private Supplier<IBufferDataSource> dataSource = () -> null;

  public RenderableDataSourceBuilder() {
  }

  @Override
  public RenderableDataSourceBuilder<T> name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public RenderableDataSourceBuilder<T> structure(Supplier<T> structure) {
    this.structure = structure;
    return this;
  }

  @SuppressWarnings({
      "unchecked",
      "rawtypes"
  })
  private RenderableDataSourceBuilder<T> _structure(final Supplier<Structure> structure) {
    this.structure = (Supplier) structure;
    return this;
  }

  @Override
  public RenderableDataSourceBuilder<T> part(int part) {
    this.part = part;
    return this;
  }

  @Override
  public RenderableDataSourceBuilder<T> dataSource(Supplier<IBufferDataSource> dataSource) {
    this.dataSource = dataSource;
    return this;
  }

  @Override
  public RenderableDataSource<T> build() {
    final var built = new RenderableDataSourceImpl<T>(name, structure.get(), part);
    built.dataSource(dataSource.get());
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
    private static final FeatureInserter<RenderableDataSourceBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<RenderableDataSourceBuilder>(2, Inserters::attributeIndex).add(RenderableDataSource.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(RenderableDataSource.FeatureIDs.PART, (builder, value) -> builder.part((int) value)).build();
    private static final RelationLazyInserter<RenderableDataSourceBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<RenderableDataSourceBuilder>(2, Inserters::relationIndex).add(RenderableDataSource.FeatureIDs.STRUCTURE, (builder, value) -> builder._structure((Supplier<Structure>) value)).add(RenderableDataSource.FeatureIDs.DATA_SOURCE, (builder, value) -> builder.dataSource((Supplier<IBufferDataSource>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case RenderableDataSource.FeatureIDs.NAME -> 0;
        case RenderableDataSource.FeatureIDs.PART -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case RenderableDataSource.FeatureIDs.STRUCTURE -> 0;
        case RenderableDataSource.FeatureIDs.DATA_SOURCE -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
