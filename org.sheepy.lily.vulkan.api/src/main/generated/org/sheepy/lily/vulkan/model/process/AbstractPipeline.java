package org.sheepy.lily.vulkan.model.process;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.types.LNamedElement;

public interface AbstractPipeline extends LNamedElement {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  boolean allocate();
  boolean record();
  PipelineExtensionPkg extensionPkg();
  void allocate(final boolean allocate);
  void record(final boolean record);
  void extensionPkg(final PipelineExtensionPkg extensionPkg);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ALLOCATE = -1954582990;
    int RECORD = -129891194;
    int EXTENSION_PKG = -758178430;
  }

  interface Features<T extends Features<T>> extends LNamedElement.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> ALLOCATE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("allocate").defaultValue("true").id(AbstractPipeline.FeatureIDs.ALLOCATE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> RECORD = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("record").defaultValue("true").id(AbstractPipeline.FeatureIDs.RECORD).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Relation<PipelineExtensionPkg, PipelineExtensionPkg, Listener<PipelineExtensionPkg>, Features<?>> EXTENSION_PKG = new RelationBuilder<PipelineExtensionPkg, PipelineExtensionPkg, Listener<PipelineExtensionPkg>, Features<?>>().name("extensionPkg").contains(true).id(AbstractPipeline.FeatureIDs.EXTENSION_PKG).concept(() -> ProcessModelDefinition.Groups.PIPELINE_EXTENSION_PKG).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ALLOCATE, RECORD, EXTENSION_PKG);
  }
}
