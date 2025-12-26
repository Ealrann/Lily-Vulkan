package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.VertexInputStateBuilder;

public interface VertexInputState extends LMObject {
  static Builder builder() {
    return new VertexInputStateBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<InputDescriptor> inputDescriptor();

  interface FeatureIDs {
    int INPUT_DESCRIPTOR = -1975783343;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<InputDescriptor, List<InputDescriptor>, Listener<List<InputDescriptor>>, Features<?>> INPUT_DESCRIPTOR = new RelationBuilder<InputDescriptor, List<InputDescriptor>, Listener<List<InputDescriptor>>, Features<?>>().name("inputDescriptor").many(true).contains(true).id(VertexInputState.FeatureIDs.INPUT_DESCRIPTOR).concept(() -> GraphicModelDefinition.Groups.INPUT_DESCRIPTOR).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(INPUT_DESCRIPTOR);
  }

  interface Builder extends IFeaturedObject.Builder<VertexInputState> {
    Builder addInputDescriptor(Supplier<InputDescriptor> inputDescriptor);
    Builder addInputDescriptor(List<InputDescriptor> inputDescriptor);
  }
}
