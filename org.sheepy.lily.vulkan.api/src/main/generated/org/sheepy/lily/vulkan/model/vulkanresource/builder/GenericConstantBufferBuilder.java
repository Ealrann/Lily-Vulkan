package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.core.model.variable.ModelVariablePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.GenericConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.GenericConstantBuffer.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.GenericConstantBufferImpl;

public final class GenericConstantBufferBuilder implements Builder {
  private String name;
  private ByteBuffer data;
  private final List<Supplier<IModelVariable>> referencedVariables = new ArrayList<>();
  private Supplier<ModelVariablePkg> VariablePkg = () -> null;

  public GenericConstantBufferBuilder() {
  }

  @Override
  public GenericConstantBufferBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public GenericConstantBufferBuilder data(ByteBuffer data) {
    this.data = data;
    return this;
  }

  @Override
  public GenericConstantBufferBuilder addReferencedVariable(
      Supplier<IModelVariable> referencedVariable) {
    this.referencedVariables.add(referencedVariable);
    return this;
  }

  @Override
  public GenericConstantBufferBuilder addReferencedVariables(
      final List<IModelVariable> referencedVariables) {
    referencedVariables.forEach(value -> this.referencedVariables.add(() -> value));
    return this;
  }

  @Override
  public GenericConstantBufferBuilder VariablePkg(Supplier<ModelVariablePkg> VariablePkg) {
    this.VariablePkg = VariablePkg;
    return this;
  }

  @Override
  public GenericConstantBuffer build() {
    final var builtReferencedVariables = BuildUtils.collectSuppliers(referencedVariables);
    final var built = new GenericConstantBufferImpl(name);
    built.data(data);
    built.referencedVariables().addAll(builtReferencedVariables);
    built.VariablePkg(VariablePkg.get());
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
    private static final FeatureInserter<GenericConstantBufferBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<GenericConstantBufferBuilder>(2, Inserters::attributeIndex).add(GenericConstantBuffer.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(GenericConstantBuffer.FeatureIDs.DATA, (builder, value) -> builder.data((ByteBuffer) value)).build();
    private static final RelationLazyInserter<GenericConstantBufferBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<GenericConstantBufferBuilder>(2, Inserters::relationIndex).add(GenericConstantBuffer.FeatureIDs.REFERENCED_VARIABLES, (builder, value) -> builder.addReferencedVariable((Supplier<IModelVariable>) value)).add(GenericConstantBuffer.FeatureIDs.VARIABLE_PKG, (builder, value) -> builder.VariablePkg((Supplier<ModelVariablePkg>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case GenericConstantBuffer.FeatureIDs.NAME -> 0;
        case GenericConstantBuffer.FeatureIDs.DATA -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case GenericConstantBuffer.FeatureIDs.REFERENCED_VARIABLES -> 0;
        case GenericConstantBuffer.FeatureIDs.VARIABLE_PKG -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
