package org.sheepy.lily.vulkan.model.vulkanresource;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.core.model.variable.ModelVariablePkg;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.GenericConstantBufferBuilder;

public interface GenericConstantBuffer extends ConstantBuffer {
  static Builder builder() {
    return new GenericConstantBufferBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IModelVariable> referencedVariables();
  ModelVariablePkg VariablePkg();
  void VariablePkg(final ModelVariablePkg VariablePkg);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int DATA = ConstantBuffer.FeatureIDs.DATA;
    int REFERENCED_VARIABLES = 1886021108;
    int VARIABLE_PKG = 2088517254;
  }

  interface Features<T extends Features<T>> extends ConstantBuffer.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<ByteBuffer, ByteBuffer, Listener<ByteBuffer>, ConstantBuffer.Features<?>> DATA = ConstantBuffer.Features.DATA;
    Relation<IModelVariable, List<IModelVariable>, Listener<List<IModelVariable>>, Features<?>> REFERENCED_VARIABLES = new RelationBuilder<IModelVariable, List<IModelVariable>, Listener<List<IModelVariable>>, Features<?>>().name("referencedVariables").many(true).id(GenericConstantBuffer.FeatureIDs.REFERENCED_VARIABLES).concept(() -> VariableModelDefinition.Groups.I_MODEL_VARIABLE).build();
    Relation<ModelVariablePkg, ModelVariablePkg, Listener<ModelVariablePkg>, Features<?>> VARIABLE_PKG = new RelationBuilder<ModelVariablePkg, ModelVariablePkg, Listener<ModelVariablePkg>, Features<?>>().name("VariablePkg").contains(true).id(GenericConstantBuffer.FeatureIDs.VARIABLE_PKG).concept(() -> VariableModelDefinition.Groups.MODEL_VARIABLE_PKG).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, DATA, REFERENCED_VARIABLES, VARIABLE_PKG);
  }

  interface Builder extends IFeaturedObject.Builder<GenericConstantBuffer> {
    Builder name(String name);
    Builder data(ByteBuffer data);
    Builder addReferencedVariable(Supplier<IModelVariable> referencedVariable);
    Builder VariablePkg(Supplier<ModelVariablePkg> VariablePkg);
    Builder addReferencedVariables(List<IModelVariable> referencedVariables);
  }
}
