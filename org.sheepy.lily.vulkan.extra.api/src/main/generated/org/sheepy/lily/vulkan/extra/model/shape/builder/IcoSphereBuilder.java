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
import org.sheepy.lily.vulkan.extra.model.shape.IcoSphere;
import org.sheepy.lily.vulkan.extra.model.shape.IcoSphere.Builder;
import org.sheepy.lily.vulkan.extra.model.shape.impl.IcoSphereImpl;

public final class IcoSphereBuilder implements Builder {
  private final List<Supplier<GeometricMesh>> meshes = new ArrayList<>();
  private int subdivisionCount = 2;

  public IcoSphereBuilder() {
  }

  @Override
  public IcoSphereBuilder addMeshe(Supplier<GeometricMesh> meshe) {
    this.meshes.add(meshe);
    return this;
  }

  @SuppressWarnings({
      "unchecked",
      "rawtypes"
  })
  private IcoSphereBuilder _meshes(final Supplier<Mesh> meshe) {
    this.meshes.add((Supplier) meshe);
    return this;
  }

  @Override
  public IcoSphereBuilder addMeshes(final List<GeometricMesh> meshes) {
    meshes.forEach(value -> this._meshes(() -> value));
    return this;
  }

  @Override
  public IcoSphereBuilder subdivisionCount(int subdivisionCount) {
    this.subdivisionCount = subdivisionCount;
    return this;
  }

  @Override
  public IcoSphere build() {
    final var builtMeshes = BuildUtils.collectSuppliers(meshes);
    final var built = new IcoSphereImpl(builtMeshes);
    built.subdivisionCount(subdivisionCount);
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
    private static final FeatureInserter<IcoSphereBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<IcoSphereBuilder>(1, Inserters::attributeIndex).add(IcoSphere.FeatureIDs.SUBDIVISION_COUNT, (builder, value) -> builder.subdivisionCount((int) value)).build();
    private static final RelationLazyInserter<IcoSphereBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<IcoSphereBuilder>(1, Inserters::relationIndex).add(IcoSphere.FeatureIDs.MESHES, (builder, value) -> builder._meshes((Supplier<Mesh>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case IcoSphere.FeatureIDs.SUBDIVISION_COUNT -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case IcoSphere.FeatureIDs.MESHES -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
