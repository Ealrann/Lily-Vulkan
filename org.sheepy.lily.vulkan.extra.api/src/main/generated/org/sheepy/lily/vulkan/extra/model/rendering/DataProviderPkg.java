package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.GenericParameterBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.DataProviderPkgBuilder;

public interface DataProviderPkg<T extends Structure> extends LMObject {
  static <T extends Structure> Builder<T> builder() {
    return new DataProviderPkgBuilder<>();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<DataProvider<T>> dataProviders();

  interface FeatureIDs {
    int DATA_PROVIDERS = -1890443955;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<DataProvider<?>, List<DataProvider<?>>, Listener<List<DataProvider<?>>>, Features<?>> DATA_PROVIDERS = new RelationBuilder<DataProvider<?>, List<DataProvider<?>>, Listener<List<DataProvider<?>>>, Features<?>>().name("dataProviders").many(true).mandatory(true).contains(true).id(DataProviderPkg.FeatureIDs.DATA_PROVIDERS).concept(() -> RenderingModelDefinition.Groups.DATA_PROVIDER).addParameter(() -> new GenericParameterBuilder().type(() -> RenderingModelDefinition.Generics.DATA_PROVIDER_PKG.T).build()).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(DATA_PROVIDERS);
  }

  interface Builder<T extends Structure> extends IFeaturedObject.Builder<DataProviderPkg<T>> {
    Builder<T> addDataProvider(Supplier<DataProvider<T>> dataProvider);
    Builder<T> addDataProviders(List<DataProvider<?>> dataProviders);
  }
}
