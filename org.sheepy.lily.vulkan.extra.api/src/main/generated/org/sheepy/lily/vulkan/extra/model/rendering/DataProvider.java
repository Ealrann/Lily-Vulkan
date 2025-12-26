package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.FloatListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.api.notification.listener.LongListener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.DataProviderBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface DataProvider<T extends Structure> extends LMObject {
  static <T extends Structure> Builder<T> builder() {
    return new DataProviderBuilder<>();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<EBufferUsage> usages();
  float growFactor();
  long minSize();
  IBufferDataSource dataSource();
  String dataSourceName();
  void growFactor(final float growFactor);
  void minSize(final long minSize);
  void dataSource(final IBufferDataSource dataSource);
  void dataSourceName(final String dataSourceName);

  interface FeatureIDs {
    int USAGES = -993655313;
    int GROW_FACTOR = 471457727;
    int MIN_SIZE = 476484118;
    int DATA_SOURCE = -112499486;
    int DATA_SOURCE_NAME = -376499571;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<EBufferUsage, List<EBufferUsage>, Listener<List<EBufferUsage>>, Features<?>> USAGES = new AttributeBuilder<EBufferUsage, List<EBufferUsage>, Listener<List<EBufferUsage>>, Features<?>>().name("usages").many(true).mandatory(true).id(DataProvider.FeatureIDs.USAGES).datatype(() -> EnumerationModelDefinition.Enums.E_BUFFER_USAGE).build();
    Attribute<Float, Float, FloatListener, Features<?>> GROW_FACTOR = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("growFactor").mandatory(true).defaultValue("1.5f").id(DataProvider.FeatureIDs.GROW_FACTOR).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    Attribute<Long, Long, LongListener, Features<?>> MIN_SIZE = new AttributeBuilder<Long, Long, LongListener, Features<?>>().name("minSize").defaultValue("0").id(DataProvider.FeatureIDs.MIN_SIZE).datatype(() -> LMCoreModelDefinition.Units.LONG).build();
    Relation<IBufferDataSource, IBufferDataSource, Listener<IBufferDataSource>, Features<?>> DATA_SOURCE = new RelationBuilder<IBufferDataSource, IBufferDataSource, Listener<IBufferDataSource>, Features<?>>().name("dataSource").id(DataProvider.FeatureIDs.DATA_SOURCE).concept(() -> VulkanResourceModelDefinition.Groups.I_BUFFER_DATA_SOURCE).build();
    Attribute<String, String, Listener<String>, Features<?>> DATA_SOURCE_NAME = new AttributeBuilder<String, String, Listener<String>, Features<?>>().name("dataSourceName").mandatory(true).id(DataProvider.FeatureIDs.DATA_SOURCE_NAME).datatype(() -> LMCoreModelDefinition.Units.STRING).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(USAGES, GROW_FACTOR, MIN_SIZE, DATA_SOURCE, DATA_SOURCE_NAME);
  }

  interface Builder<T extends Structure> extends IFeaturedObject.Builder<DataProvider<T>> {
    Builder<T> addUsage(EBufferUsage usage);
    Builder<T> growFactor(float growFactor);
    Builder<T> minSize(long minSize);
    Builder<T> dataSource(Supplier<IBufferDataSource> dataSource);
    Builder<T> dataSourceName(String dataSourceName);
    Builder<T> addUsages(List<EBufferUsage> usages);
  }
}
