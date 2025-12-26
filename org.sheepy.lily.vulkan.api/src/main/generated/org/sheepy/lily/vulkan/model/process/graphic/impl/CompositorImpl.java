package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.application.CompositorExtensionPkg;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.core.model.variable.ModelVariablePkg;
import org.sheepy.lily.vulkan.model.process.graphic.Attachment;
import org.sheepy.lily.vulkan.model.process.graphic.Compositor;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkanresource.Shader;

public final class CompositorImpl extends FeaturedObject<Compositor.Features<?>> implements Compositor {
  private static final int FEATURE_COUNT = 9;
  private final ModelNotifier<Compositor.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private CompositorExtensionPkg extensionPkg;
  private boolean enabled;
  private Shader vertexShader;
  private Shader fragmentShader;
  private final List<Attachment> colorAttachments = newObservableList(Compositor.FeatureIDs.COLOR_ATTACHMENTS, true, false);
  private final List<ExtraAttachment> inputAttachments = newObservableList(Compositor.FeatureIDs.INPUT_ATTACHMENTS, true, false);
  private ModelVariablePkg constantVariables;
  private DescriptorPkg descriptorPkg;

  public CompositorImpl(final String name, final boolean enabled, final Shader vertexShader,
      final Shader fragmentShader, final List<Attachment> colorAttachments) {
    this.name = name;
    this.enabled = enabled;
    this.vertexShader = vertexShader;
    this.fragmentShader = fragmentShader;
    this.colorAttachments.addAll(colorAttachments);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Compositor.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public CompositorExtensionPkg extensionPkg() {
    return extensionPkg;
  }

  @Override
  public void extensionPkg(final CompositorExtensionPkg extensionPkg) {
    final var oldValue = this.extensionPkg;
    final var eventType = extensionPkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.extensionPkg = extensionPkg;
    setContainer(extensionPkg, ICompositor.FeatureIDs.EXTENSION_PKG);
    beforeContainmentNotify(eventType, oldValue, extensionPkg);
    notifier.notify(ICompositor.FeatureIDs.EXTENSION_PKG, true, false, eventType, oldValue, extensionPkg);
    afterContainmentNotify(eventType, oldValue, extensionPkg);
  }

  @Override
  public boolean enabled() {
    return enabled;
  }

  @Override
  public void enabled(final boolean enabled) {
    final var oldValue = this.enabled;
    this.enabled = enabled;
    notifier.notifyBoolean(ICompositor.FeatureIDs.ENABLED, false, false, oldValue, enabled);
  }

  @Override
  public Shader vertexShader() {
    return vertexShader;
  }

  @Override
  public void vertexShader(final Shader vertexShader) {
    final var oldValue = this.vertexShader;
    final var eventType = vertexShader == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.vertexShader = vertexShader;
    notifier.notify(Compositor.FeatureIDs.VERTEX_SHADER, false, false, eventType, oldValue, vertexShader);
  }

  @Override
  public Shader fragmentShader() {
    return fragmentShader;
  }

  @Override
  public void fragmentShader(final Shader fragmentShader) {
    final var oldValue = this.fragmentShader;
    final var eventType = fragmentShader == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.fragmentShader = fragmentShader;
    notifier.notify(Compositor.FeatureIDs.FRAGMENT_SHADER, false, false, eventType, oldValue, fragmentShader);
  }

  @Override
  public List<Attachment> colorAttachments() {
    return colorAttachments;
  }

  @Override
  public List<ExtraAttachment> inputAttachments() {
    return inputAttachments;
  }

  @Override
  public ModelVariablePkg constantVariables() {
    return constantVariables;
  }

  @Override
  public void constantVariables(final ModelVariablePkg constantVariables) {
    final var oldValue = this.constantVariables;
    final var eventType = constantVariables == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.constantVariables = constantVariables;
    setContainer(constantVariables, Compositor.FeatureIDs.CONSTANT_VARIABLES);
    beforeContainmentNotify(eventType, oldValue, constantVariables);
    notifier.notify(Compositor.FeatureIDs.CONSTANT_VARIABLES, true, false, eventType, oldValue, constantVariables);
    afterContainmentNotify(eventType, oldValue, constantVariables);
  }

  @Override
  public DescriptorPkg descriptorPkg() {
    return descriptorPkg;
  }

  @Override
  public void descriptorPkg(final DescriptorPkg descriptorPkg) {
    final var oldValue = this.descriptorPkg;
    final var eventType = descriptorPkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.descriptorPkg = descriptorPkg;
    setContainer(descriptorPkg, Compositor.FeatureIDs.DESCRIPTOR_PKG);
    beforeContainmentNotify(eventType, oldValue, descriptorPkg);
    notifier.notify(Compositor.FeatureIDs.DESCRIPTOR_PKG, true, false, eventType, oldValue, descriptorPkg);
    afterContainmentNotify(eventType, oldValue, descriptorPkg);
  }

  @Override
  public Group<Compositor> lmGroup() {
    return GraphicModelDefinition.Groups.COMPOSITOR;
  }

  @Override
  protected FeatureSetter<Compositor> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Compositor> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Compositor.FeatureIDs.NAME -> 0;
      case Compositor.FeatureIDs.EXTENSION_PKG -> 1;
      case Compositor.FeatureIDs.ENABLED -> 2;
      case Compositor.FeatureIDs.VERTEX_SHADER -> 3;
      case Compositor.FeatureIDs.FRAGMENT_SHADER -> 4;
      case Compositor.FeatureIDs.COLOR_ATTACHMENTS -> 5;
      case Compositor.FeatureIDs.INPUT_ATTACHMENTS -> 6;
      case Compositor.FeatureIDs.CONSTANT_VARIABLES -> 7;
      case Compositor.FeatureIDs.DESCRIPTOR_PKG -> 8;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Compositor> GET_MAP = new FeatureGetter.Builder<Compositor>(FEATURE_COUNT, CompositorImpl::featureIndexStatic).add(Compositor.FeatureIDs.NAME, Compositor::name).add(Compositor.FeatureIDs.EXTENSION_PKG, Compositor::extensionPkg).add(Compositor.FeatureIDs.ENABLED, Compositor::enabled).add(Compositor.FeatureIDs.VERTEX_SHADER, Compositor::vertexShader).add(Compositor.FeatureIDs.FRAGMENT_SHADER, Compositor::fragmentShader).add(Compositor.FeatureIDs.COLOR_ATTACHMENTS, Compositor::colorAttachments).add(Compositor.FeatureIDs.INPUT_ATTACHMENTS, Compositor::inputAttachments).add(Compositor.FeatureIDs.CONSTANT_VARIABLES, Compositor::constantVariables).add(Compositor.FeatureIDs.DESCRIPTOR_PKG, Compositor::descriptorPkg).build();
    private static final FeatureSetter<Compositor> SET_MAP = new FeatureSetter.Builder<Compositor>(FEATURE_COUNT, CompositorImpl::featureIndexStatic).add(Compositor.FeatureIDs.EXTENSION_PKG, (object, value) -> ((CompositorImpl) object).extensionPkg((CompositorExtensionPkg) value)).add(Compositor.FeatureIDs.ENABLED, (object, value) -> ((CompositorImpl) object).enabled((boolean) value)).add(Compositor.FeatureIDs.VERTEX_SHADER, (object, value) -> ((CompositorImpl) object).vertexShader((Shader) value)).add(Compositor.FeatureIDs.FRAGMENT_SHADER, (object, value) -> ((CompositorImpl) object).fragmentShader((Shader) value)).add(Compositor.FeatureIDs.CONSTANT_VARIABLES, (object, value) -> ((CompositorImpl) object).constantVariables((ModelVariablePkg) value)).add(Compositor.FeatureIDs.DESCRIPTOR_PKG, (object, value) -> ((CompositorImpl) object).descriptorPkg((DescriptorPkg) value)).build();
  }
}
