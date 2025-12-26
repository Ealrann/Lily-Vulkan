package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.vulkan.model.vulkanresource.Shader;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.pipeline.SpecializationConstant;

public final class ShaderImpl extends FeaturedObject<Shader.Features<?>> implements Shader {
  private static final int FEATURE_COUNT = 4;
  private final ModelNotifier<Shader.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private FileResource file;
  private EShaderStage stage;
  private final List<SpecializationConstant> constants = newObservableList(Shader.FeatureIDs.CONSTANTS, true, true);

  public ShaderImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Shader.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public FileResource file() {
    return file;
  }

  @Override
  public void file(final FileResource file) {
    final var oldValue = this.file;
    final var eventType = file == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.file = file;
    setContainer(file, Shader.FeatureIDs.FILE);
    beforeContainmentNotify(eventType, oldValue, file);
    notifier.notify(Shader.FeatureIDs.FILE, true, false, eventType, oldValue, file);
    afterContainmentNotify(eventType, oldValue, file);
  }

  @Override
  public EShaderStage stage() {
    return stage;
  }

  @Override
  public void stage(final EShaderStage stage) {
    final var oldValue = this.stage;
    this.stage = stage;
    notifier.notify(Shader.FeatureIDs.STAGE, false, false, oldValue, stage);
  }

  @Override
  public List<SpecializationConstant> constants() {
    return constants;
  }

  @Override
  public Group<Shader> lmGroup() {
    return VulkanResourceModelDefinition.Groups.SHADER;
  }

  @Override
  protected FeatureSetter<Shader> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Shader> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Shader.FeatureIDs.NAME -> 0;
      case Shader.FeatureIDs.FILE -> 1;
      case Shader.FeatureIDs.STAGE -> 2;
      case Shader.FeatureIDs.CONSTANTS -> 3;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Shader> GET_MAP = new FeatureGetter.Builder<Shader>(FEATURE_COUNT, ShaderImpl::featureIndexStatic).add(Shader.FeatureIDs.NAME, Shader::name).add(Shader.FeatureIDs.FILE, Shader::file).add(Shader.FeatureIDs.STAGE, Shader::stage).add(Shader.FeatureIDs.CONSTANTS, Shader::constants).build();
    private static final FeatureSetter<Shader> SET_MAP = new FeatureSetter.Builder<Shader>(FEATURE_COUNT, ShaderImpl::featureIndexStatic).add(Shader.FeatureIDs.FILE, (object, value) -> ((ShaderImpl) object).file((FileResource) value)).add(Shader.FeatureIDs.STAGE, (object, value) -> ((ShaderImpl) object).stage((EShaderStage) value)).build();
  }
}
