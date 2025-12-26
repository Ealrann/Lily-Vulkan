package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.InputDescriptorBuilder;
import org.sheepy.vulkan.model.enumeration.EInputRate;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface InputDescriptor extends LMObject {
  static Builder builder() {
    return new InputDescriptorBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  EInputRate inputRate();
  int strideLength();
  List<AttributeDescription> attributes();
  void inputRate(final EInputRate inputRate);
  void strideLength(final int strideLength);

  interface FeatureIDs {
    int INPUT_RATE = -1435780350;
    int STRIDE_LENGTH = 415349991;
    int ATTRIBUTES = 1766979871;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<EInputRate, EInputRate, Listener<EInputRate>, Features<?>> INPUT_RATE = new AttributeBuilder<EInputRate, EInputRate, Listener<EInputRate>, Features<?>>().name("inputRate").defaultValue("VERTEX").id(InputDescriptor.FeatureIDs.INPUT_RATE).datatype(() -> EnumerationModelDefinition.Enums.E_INPUT_RATE).build();
    Attribute<Integer, Integer, IntListener, Features<?>> STRIDE_LENGTH = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("strideLength").id(InputDescriptor.FeatureIDs.STRIDE_LENGTH).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Relation<AttributeDescription, List<AttributeDescription>, Listener<List<AttributeDescription>>, Features<?>> ATTRIBUTES = new RelationBuilder<AttributeDescription, List<AttributeDescription>, Listener<List<AttributeDescription>>, Features<?>>().name("attributes").many(true).mandatory(true).contains(true).id(InputDescriptor.FeatureIDs.ATTRIBUTES).concept(() -> GraphicModelDefinition.Groups.ATTRIBUTE_DESCRIPTION).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(INPUT_RATE, STRIDE_LENGTH, ATTRIBUTES);
  }

  interface Builder extends IFeaturedObject.Builder<InputDescriptor> {
    Builder inputRate(EInputRate inputRate);
    Builder strideLength(int strideLength);
    Builder addAttribute(Supplier<AttributeDescription> attribute);
    Builder addAttributes(List<AttributeDescription> attributes);
  }
}
