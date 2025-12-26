package org.sheepy.vulkan.model.pipeline;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.vulkan.model.pipeline.builder.SpecializationConstantBuilder;

public interface SpecializationConstant extends LMObject {
  static Builder builder() {
    return new SpecializationConstantBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  String name();
  int constantId();
  int size();
  void name(final String name);
  void constantId(final int constantId);
  void size(final int size);

  interface FeatureIDs {
    int NAME = -151889236;
    int CONSTANT_ID = -1451092160;
    int SIZE = -151732190;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<String, String, Listener<String>, Features<?>> NAME = new AttributeBuilder<String, String, Listener<String>, Features<?>>().name("name").id(SpecializationConstant.FeatureIDs.NAME).datatype(() -> LMCoreModelDefinition.Units.STRING).build();
    Attribute<Integer, Integer, IntListener, Features<?>> CONSTANT_ID = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("constantId").id(SpecializationConstant.FeatureIDs.CONSTANT_ID).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> SIZE = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("size").id(SpecializationConstant.FeatureIDs.SIZE).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, CONSTANT_ID, SIZE);
  }

  interface Builder extends IFeaturedObject.Builder<SpecializationConstant> {
    Builder name(String name);
    Builder constantId(int constantId);
    Builder size(int size);
  }
}
