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
import org.sheepy.lily.vulkan.extra.model.shape.Icosahedron;
import org.sheepy.lily.vulkan.extra.model.shape.Icosahedron.Builder;
import org.sheepy.lily.vulkan.extra.model.shape.impl.IcosahedronImpl;

public final class IcosahedronBuilder implements Builder {
  private final List<Supplier<GeometricMesh>> meshes = new ArrayList<>();

  public IcosahedronBuilder() {
  }

  @Override
  public IcosahedronBuilder addMeshe(Supplier<GeometricMesh> meshe) {
    this.meshes.add(meshe);
    return this;
  }

  @SuppressWarnings({
      "unchecked",
      "rawtypes"
  })
  private IcosahedronBuilder _meshes(final Supplier<Mesh> meshe) {
    this.meshes.add((Supplier) meshe);
    return this;
  }

  @Override
  public IcosahedronBuilder addMeshes(final List<GeometricMesh> meshes) {
    meshes.forEach(value -> this._meshes(() -> value));
    return this;
  }

  @Override
  public Icosahedron build() {
    final var builtMeshes = BuildUtils.collectSuppliers(meshes);
    final var built = new IcosahedronImpl(builtMeshes);
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
    private static final FeatureInserter<IcosahedronBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<IcosahedronBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<IcosahedronBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<IcosahedronBuilder>(1, Inserters::relationIndex).add(Icosahedron.FeatureIDs.MESHES, (builder, value) -> builder._meshes((Supplier<Mesh>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Icosahedron.FeatureIDs.MESHES -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
