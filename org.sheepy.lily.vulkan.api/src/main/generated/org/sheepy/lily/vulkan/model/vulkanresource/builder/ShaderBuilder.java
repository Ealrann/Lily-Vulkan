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
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.vulkan.model.vulkanresource.Shader;
import org.sheepy.lily.vulkan.model.vulkanresource.Shader.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.ShaderImpl;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.pipeline.SpecializationConstant;

public final class ShaderBuilder implements Builder {
  private String name;
  private Supplier<FileResource> file = () -> null;
  private EShaderStage stage = EShaderStage.VERTEX_BIT;
  private final List<Supplier<SpecializationConstant>> constants = new ArrayList<>();

  public ShaderBuilder() {
  }

  @Override
  public ShaderBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public ShaderBuilder file(Supplier<FileResource> file) {
    this.file = file;
    return this;
  }

  @Override
  public ShaderBuilder stage(EShaderStage stage) {
    this.stage = stage;
    return this;
  }

  @Override
  public ShaderBuilder addConstant(Supplier<SpecializationConstant> constant) {
    this.constants.add(constant);
    return this;
  }

  @Override
  public ShaderBuilder addConstants(final List<SpecializationConstant> constants) {
    constants.forEach(value -> this.constants.add(() -> value));
    return this;
  }

  @Override
  public Shader build() {
    final var builtConstants = BuildUtils.collectSuppliers(constants);
    final var built = new ShaderImpl(name);
    built.file(file.get());
    built.stage(stage);
    built.constants().addAll(builtConstants);
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
    private static final FeatureInserter<ShaderBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ShaderBuilder>(2, Inserters::attributeIndex).add(Shader.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(Shader.FeatureIDs.STAGE, (builder, value) -> builder.stage((EShaderStage) value)).build();
    private static final RelationLazyInserter<ShaderBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ShaderBuilder>(2, Inserters::relationIndex).add(Shader.FeatureIDs.FILE, (builder, value) -> builder.file((Supplier<FileResource>) value)).add(Shader.FeatureIDs.CONSTANTS, (builder, value) -> builder.addConstant((Supplier<SpecializationConstant>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Shader.FeatureIDs.NAME -> 0;
        case Shader.FeatureIDs.STAGE -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Shader.FeatureIDs.FILE -> 0;
        case Shader.FeatureIDs.CONSTANTS -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
