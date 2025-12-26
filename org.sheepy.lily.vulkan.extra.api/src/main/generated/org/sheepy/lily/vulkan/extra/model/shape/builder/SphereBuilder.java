package org.sheepy.lily.vulkan.extra.model.shape.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.extra.model.mesh.Mesh;
import org.sheepy.lily.vulkan.extra.model.shape.GeometricMesh;
import org.sheepy.lily.vulkan.extra.model.shape.Sphere;
import org.sheepy.lily.vulkan.extra.model.shape.Sphere.Builder;
import org.sheepy.lily.vulkan.extra.model.shape.impl.SphereImpl;

public final class SphereBuilder implements Builder {
  private final List<Supplier<GeometricMesh>> meshes = new ArrayList<>();
  private int sliceCount = 12;

  public SphereBuilder() {
  }

  @Override
  public SphereBuilder addMeshe(Supplier<GeometricMesh> meshe) {
    this.meshes.add(meshe);
    return this;
  }

  @SuppressWarnings({
      "unchecked",
      "rawtypes"
  })
  private SphereBuilder _meshes(final Supplier<Mesh> meshe) {
    this.meshes.add((Supplier) meshe);
    return this;
  }

  @Override
  public SphereBuilder addMeshes(final List<GeometricMesh> meshes) {
    meshes.forEach(value -> this._meshes(() -> value));
    return this;
  }

  @Override
  public SphereBuilder sliceCount(int sliceCount) {
    this.sliceCount = sliceCount;
    return this;
  }

  @Override
  public Sphere build() {
    final var builtMeshes = BuildUtils.collectSuppliers(meshes);
    final var built = new SphereImpl(builtMeshes);
    built.sliceCount(sliceCount);
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
    private static final FeatureInserter<SphereBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<SphereBuilder>(1, Inserters::attributeIndex).add(Sphere.FeatureIDs.SLICE_COUNT, (builder, value) -> builder.sliceCount((int) value)).build();
    private static final RelationLazyInserter<SphereBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<SphereBuilder>(1, Inserters::relationIndex).add(Sphere.FeatureIDs.MESHES, (builder, value) -> builder._meshes((Supplier<Mesh>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Sphere.FeatureIDs.SLICE_COUNT -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Sphere.FeatureIDs.MESHES -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
