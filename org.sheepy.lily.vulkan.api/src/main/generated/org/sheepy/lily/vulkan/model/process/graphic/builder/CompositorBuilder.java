package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.application.CompositorExtensionPkg;
import org.sheepy.lily.core.model.variable.ModelVariablePkg;
import org.sheepy.lily.vulkan.model.process.graphic.Attachment;
import org.sheepy.lily.vulkan.model.process.graphic.Compositor;
import org.sheepy.lily.vulkan.model.process.graphic.Compositor.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.impl.CompositorImpl;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkanresource.Shader;

public final class CompositorBuilder implements Builder {
  private String name;
  private Supplier<CompositorExtensionPkg> extensionPkg = () -> null;
  private boolean enabled = true;
  private Supplier<Shader> vertexShader;
  private Supplier<Shader> fragmentShader;
  private final List<Supplier<Attachment>> colorAttachments = new ArrayList<>();
  private final List<Supplier<ExtraAttachment>> inputAttachments = new ArrayList<>();
  private Supplier<ModelVariablePkg> constantVariables = () -> null;
  private Supplier<DescriptorPkg> descriptorPkg = () -> null;

  public CompositorBuilder() {
  }

  @Override
  public CompositorBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public CompositorBuilder extensionPkg(Supplier<CompositorExtensionPkg> extensionPkg) {
    this.extensionPkg = extensionPkg;
    return this;
  }

  @Override
  public CompositorBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public CompositorBuilder vertexShader(Supplier<Shader> vertexShader) {
    this.vertexShader = vertexShader;
    return this;
  }

  @Override
  public CompositorBuilder fragmentShader(Supplier<Shader> fragmentShader) {
    this.fragmentShader = fragmentShader;
    return this;
  }

  @Override
  public CompositorBuilder addColorAttachment(Supplier<Attachment> colorAttachment) {
    this.colorAttachments.add(colorAttachment);
    return this;
  }

  @Override
  public CompositorBuilder addColorAttachments(final List<Attachment> colorAttachments) {
    colorAttachments.forEach(value -> this.colorAttachments.add(() -> value));
    return this;
  }

  @Override
  public CompositorBuilder addInputAttachment(Supplier<ExtraAttachment> inputAttachment) {
    this.inputAttachments.add(inputAttachment);
    return this;
  }

  @Override
  public CompositorBuilder addInputAttachments(final List<ExtraAttachment> inputAttachments) {
    inputAttachments.forEach(value -> this.inputAttachments.add(() -> value));
    return this;
  }

  @Override
  public CompositorBuilder constantVariables(Supplier<ModelVariablePkg> constantVariables) {
    this.constantVariables = constantVariables;
    return this;
  }

  @Override
  public CompositorBuilder descriptorPkg(Supplier<DescriptorPkg> descriptorPkg) {
    this.descriptorPkg = descriptorPkg;
    return this;
  }

  @Override
  public Compositor build() {
    final var builtColorAttachments = BuildUtils.collectSuppliers(colorAttachments);
    final var builtInputAttachments = BuildUtils.collectSuppliers(inputAttachments);
    final var built = new CompositorImpl(name, enabled, vertexShader.get(), fragmentShader.get(), builtColorAttachments);
    built.extensionPkg(extensionPkg.get());
    built.inputAttachments().addAll(builtInputAttachments);
    built.constantVariables(constantVariables.get());
    built.descriptorPkg(descriptorPkg.get());
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
    private static final FeatureInserter<CompositorBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<CompositorBuilder>(2, Inserters::attributeIndex).add(Compositor.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(Compositor.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).build();
    private static final RelationLazyInserter<CompositorBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<CompositorBuilder>(7, Inserters::relationIndex).add(Compositor.FeatureIDs.EXTENSION_PKG, (builder, value) -> builder.extensionPkg((Supplier<CompositorExtensionPkg>) value)).add(Compositor.FeatureIDs.VERTEX_SHADER, (builder, value) -> builder.vertexShader((Supplier<Shader>) value)).add(Compositor.FeatureIDs.FRAGMENT_SHADER, (builder, value) -> builder.fragmentShader((Supplier<Shader>) value)).add(Compositor.FeatureIDs.COLOR_ATTACHMENTS, (builder, value) -> builder.addColorAttachment((Supplier<Attachment>) value)).add(Compositor.FeatureIDs.INPUT_ATTACHMENTS, (builder, value) -> builder.addInputAttachment((Supplier<ExtraAttachment>) value)).add(Compositor.FeatureIDs.CONSTANT_VARIABLES, (builder, value) -> builder.constantVariables((Supplier<ModelVariablePkg>) value)).add(Compositor.FeatureIDs.DESCRIPTOR_PKG, (builder, value) -> builder.descriptorPkg((Supplier<DescriptorPkg>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Compositor.FeatureIDs.NAME -> 0;
        case Compositor.FeatureIDs.ENABLED -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Compositor.FeatureIDs.EXTENSION_PKG -> 0;
        case Compositor.FeatureIDs.VERTEX_SHADER -> 1;
        case Compositor.FeatureIDs.FRAGMENT_SHADER -> 2;
        case Compositor.FeatureIDs.COLOR_ATTACHMENTS -> 3;
        case Compositor.FeatureIDs.INPUT_ATTACHMENTS -> 4;
        case Compositor.FeatureIDs.CONSTANT_VARIABLES -> 5;
        case Compositor.FeatureIDs.DESCRIPTOR_PKG -> 6;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
