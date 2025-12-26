package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.application.CompositorExtensionPkg;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.variable.ModelVariablePkg;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.builder.CompositorBuilder;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.VulkanModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.Shader;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public interface Compositor extends ICompositor, LNamedElement {
  static Builder builder() {
    return new CompositorBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  Shader vertexShader();
  Shader fragmentShader();
  List<Attachment> colorAttachments();
  List<ExtraAttachment> inputAttachments();
  ModelVariablePkg constantVariables();
  DescriptorPkg descriptorPkg();
  void vertexShader(final Shader vertexShader);
  void fragmentShader(final Shader fragmentShader);
  void constantVariables(final ModelVariablePkg constantVariables);
  void descriptorPkg(final DescriptorPkg descriptorPkg);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int EXTENSION_PKG = ICompositor.FeatureIDs.EXTENSION_PKG;
    int ENABLED = ICompositor.FeatureIDs.ENABLED;
    int VERTEX_SHADER = -1139007909;
    int FRAGMENT_SHADER = 184809863;
    int COLOR_ATTACHMENTS = 1921876735;
    int INPUT_ATTACHMENTS = -1878399944;
    int CONSTANT_VARIABLES = 1265188289;
    int DESCRIPTOR_PKG = -489185685;
  }

  interface Features<T extends Features<T>> extends ICompositor.Features<T>, LNamedElement.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<CompositorExtensionPkg, CompositorExtensionPkg, Listener<CompositorExtensionPkg>, ICompositor.Features<?>> EXTENSION_PKG = ICompositor.Features.EXTENSION_PKG;
    Attribute<Boolean, Boolean, BooleanListener, ICompositor.Features<?>> ENABLED = ICompositor.Features.ENABLED;
    Relation<Shader, Shader, Listener<Shader>, Features<?>> VERTEX_SHADER = new RelationBuilder<Shader, Shader, Listener<Shader>, Features<?>>().name("vertexShader").mandatory(true).id(Compositor.FeatureIDs.VERTEX_SHADER).concept(() -> VulkanResourceModelDefinition.Groups.SHADER).build();
    Relation<Shader, Shader, Listener<Shader>, Features<?>> FRAGMENT_SHADER = new RelationBuilder<Shader, Shader, Listener<Shader>, Features<?>>().name("fragmentShader").mandatory(true).id(Compositor.FeatureIDs.FRAGMENT_SHADER).concept(() -> VulkanResourceModelDefinition.Groups.SHADER).build();
    Relation<Attachment, List<Attachment>, Listener<List<Attachment>>, Features<?>> COLOR_ATTACHMENTS = new RelationBuilder<Attachment, List<Attachment>, Listener<List<Attachment>>, Features<?>>().name("colorAttachments").many(true).mandatory(true).id(Compositor.FeatureIDs.COLOR_ATTACHMENTS).concept(() -> GraphicModelDefinition.Groups.ATTACHMENT).build();
    Relation<ExtraAttachment, List<ExtraAttachment>, Listener<List<ExtraAttachment>>, Features<?>> INPUT_ATTACHMENTS = new RelationBuilder<ExtraAttachment, List<ExtraAttachment>, Listener<List<ExtraAttachment>>, Features<?>>().name("inputAttachments").many(true).id(Compositor.FeatureIDs.INPUT_ATTACHMENTS).concept(() -> GraphicModelDefinition.Groups.EXTRA_ATTACHMENT).build();
    Relation<ModelVariablePkg, ModelVariablePkg, Listener<ModelVariablePkg>, Features<?>> CONSTANT_VARIABLES = new RelationBuilder<ModelVariablePkg, ModelVariablePkg, Listener<ModelVariablePkg>, Features<?>>().name("constantVariables").contains(true).id(Compositor.FeatureIDs.CONSTANT_VARIABLES).concept(() -> VariableModelDefinition.Groups.MODEL_VARIABLE_PKG).build();
    Relation<DescriptorPkg, DescriptorPkg, Listener<DescriptorPkg>, Features<?>> DESCRIPTOR_PKG = new RelationBuilder<DescriptorPkg, DescriptorPkg, Listener<DescriptorPkg>, Features<?>>().name("descriptorPkg").contains(true).id(Compositor.FeatureIDs.DESCRIPTOR_PKG).concept(() -> VulkanModelDefinition.Groups.DESCRIPTOR_PKG).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, EXTENSION_PKG, ENABLED, VERTEX_SHADER, FRAGMENT_SHADER, COLOR_ATTACHMENTS, INPUT_ATTACHMENTS, CONSTANT_VARIABLES, DESCRIPTOR_PKG);
  }

  interface Builder extends IFeaturedObject.Builder<Compositor> {
    Builder name(String name);
    Builder extensionPkg(Supplier<CompositorExtensionPkg> extensionPkg);
    Builder enabled(boolean enabled);
    Builder vertexShader(Supplier<Shader> vertexShader);
    Builder fragmentShader(Supplier<Shader> fragmentShader);
    Builder addColorAttachment(Supplier<Attachment> colorAttachment);
    Builder addInputAttachment(Supplier<ExtraAttachment> inputAttachment);
    Builder constantVariables(Supplier<ModelVariablePkg> constantVariables);
    Builder descriptorPkg(Supplier<DescriptorPkg> descriptorPkg);
    Builder addColorAttachments(List<Attachment> colorAttachments);
    Builder addInputAttachments(List<ExtraAttachment> inputAttachments);
  }
}
