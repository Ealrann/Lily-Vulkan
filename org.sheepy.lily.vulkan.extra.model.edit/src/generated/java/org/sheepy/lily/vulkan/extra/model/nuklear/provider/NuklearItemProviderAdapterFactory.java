/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear.provider;

import java.util.ArrayList;
import java.util.Collection;

import java.util.List;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ChildCreationExtenderManager;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.ResourcePkg;
import org.sheepy.lily.core.model.application.util.ApplicationSwitch;
import org.sheepy.lily.core.model.ui.UIPage;
import org.sheepy.lily.core.model.ui.UiPackage;
import org.sheepy.lily.core.model.ui.util.UiSwitch;
import org.sheepy.lily.vulkan.extra.model.mesh.provider.ExtraEditPlugin;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFactory;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage;
import org.sheepy.lily.vulkan.extra.model.nuklear.util.NuklearAdapterFactory;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.util.ProcessSwitch;
import org.sheepy.lily.vulkan.model.resource.BufferPart;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.model.resource.util.ResourceSwitch;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NuklearItemProviderAdapterFactory extends NuklearAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable, IChildCreationExtender
{
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This helps manage the child creation extenders.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(ExtraEditPlugin.INSTANCE, NuklearPackage.eNS_URI);

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuklearItemProviderAdapterFactory()
	{
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NuklearPushConstantsItemProvider nuklearPushConstantsItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNuklearPushConstantsAdapter()
	{
		if (nuklearPushConstantsItemProvider == null)
		{
			nuklearPushConstantsItemProvider = new NuklearPushConstantsItemProvider(this);
		}

		return nuklearPushConstantsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NuklearLayoutTaskItemProvider nuklearLayoutTaskItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearLayoutTask}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNuklearLayoutTaskAdapter()
	{
		if (nuklearLayoutTaskItemProvider == null)
		{
			nuklearLayoutTaskItemProvider = new NuklearLayoutTaskItemProvider(this);
		}

		return nuklearLayoutTaskItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFillBufferTask} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NuklearFillBufferTaskItemProvider nuklearFillBufferTaskItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFillBufferTask}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNuklearFillBufferTaskAdapter()
	{
		if (nuklearFillBufferTaskItemProvider == null)
		{
			nuklearFillBufferTaskItemProvider = new NuklearFillBufferTaskItemProvider(this);
		}

		return nuklearFillBufferTaskItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NuklearContextItemProvider nuklearContextItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNuklearContextAdapter()
	{
		if (nuklearContextItemProvider == null)
		{
			nuklearContextItemProvider = new NuklearContextItemProvider(this);
		}

		return nuklearContextItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NuklearFontItemProvider nuklearFontItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNuklearFontAdapter()
	{
		if (nuklearFontItemProvider == null)
		{
			nuklearFontItemProvider = new NuklearFontItemProvider(this);
		}

		return nuklearFontItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SelectorPanelItemProvider selectorPanelItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSelectorPanelAdapter()
	{
		if (selectorPanelItemProvider == null)
		{
			selectorPanelItemProvider = new SelectorPanelItemProvider(this);
		}

		return selectorPanelItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.nuklear.PanelViewer} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PanelViewerItemProvider panelViewerItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.nuklear.PanelViewer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPanelViewerAdapter()
	{
		if (panelViewerItemProvider == null)
		{
			panelViewerItemProvider = new PanelViewerItemProvider(this);
		}

		return panelViewerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearVertexProvider} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NuklearVertexProviderItemProvider nuklearVertexProviderItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearVertexProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNuklearVertexProviderAdapter()
	{
		if (nuklearVertexProviderItemProvider == null)
		{
			nuklearVertexProviderItemProvider = new NuklearVertexProviderItemProvider(this);
		}

		return nuklearVertexProviderItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearIndexProvider} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NuklearIndexProviderItemProvider nuklearIndexProviderItemProvider;

	/**
	 * This creates an adapter for a {@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearIndexProvider}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNuklearIndexProviderAdapter()
	{
		if (nuklearIndexProviderItemProvider == null)
		{
			nuklearIndexProviderItemProvider = new NuklearIndexProviderItemProvider(this);
		}

		return nuklearIndexProviderItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComposeableAdapterFactory getRootAdapterFactory()
	{
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory)
	{
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type)
	{
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type)
	{
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type)
	{
		if (isFactoryForType(type))
		{
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter)))
			{
				return adapter;
			}
		}

		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<IChildCreationExtender> getChildCreationExtenders()
	{
		return childCreationExtenderManager.getChildCreationExtenders();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain)
	{
		return childCreationExtenderManager.getNewChildDescriptors(object, editingDomain);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator()
	{
		return childCreationExtenderManager;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addListener(INotifyChangedListener notifyChangedListener)
	{
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void removeListener(INotifyChangedListener notifyChangedListener)
	{
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void fireNotifyChanged(Notification notification)
	{
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null)
		{
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void dispose()
	{
		if (nuklearPushConstantsItemProvider != null) nuklearPushConstantsItemProvider.dispose();
		if (nuklearLayoutTaskItemProvider != null) nuklearLayoutTaskItemProvider.dispose();
		if (nuklearFillBufferTaskItemProvider != null) nuklearFillBufferTaskItemProvider.dispose();
		if (nuklearContextItemProvider != null) nuklearContextItemProvider.dispose();
		if (nuklearFontItemProvider != null) nuklearFontItemProvider.dispose();
		if (selectorPanelItemProvider != null) selectorPanelItemProvider.dispose();
		if (panelViewerItemProvider != null) panelViewerItemProvider.dispose();
		if (nuklearVertexProviderItemProvider != null) nuklearVertexProviderItemProvider.dispose();
		if (nuklearIndexProviderItemProvider != null) nuklearIndexProviderItemProvider.dispose();
	}

	/**
	 * A child creation extender for the {@link UiPackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class UiChildCreationExtender implements IChildCreationExtender
	{
		/**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected static class CreationSwitch extends UiSwitch<Object>
		{
			/**
			 * The child descriptors being populated.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected List<Object> newChildDescriptors;

			/**
			 * The domain in which to create the children.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected EditingDomain editingDomain;

			/**
			 * Creates the a switch for populating child descriptors in the given domain.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) 
			{
				this.newChildDescriptors = newChildDescriptors;
				this.editingDomain = editingDomain;
			}
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseUIPage(UIPage object)
			{
				newChildDescriptors.add
					(createChildParameter
						(UiPackage.Literals.UI_PAGE__PANELS,
						 NuklearFactory.eINSTANCE.createSelectorPanel()));

				newChildDescriptors.add
					(createChildParameter
						(UiPackage.Literals.UI_PAGE__PANELS,
						 NuklearFactory.eINSTANCE.createPanelViewer()));

				return null;
			}
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected CommandParameter createChildParameter(Object feature, Object child)
			{
				return new CommandParameter(null, feature, child);
			}

		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain)
		{
			ArrayList<Object> result = new ArrayList<Object>();
			new CreationSwitch(result, editingDomain).doSwitch((EObject)object);
			return result;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public ResourceLocator getResourceLocator()
		{
			return ExtraEditPlugin.INSTANCE;
		}
	}

	/**
	 * A child creation extender for the {@link ProcessPackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class ProcessChildCreationExtender implements IChildCreationExtender
	{
		/**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected static class CreationSwitch extends ProcessSwitch<Object>
		{
			/**
			 * The child descriptors being populated.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected List<Object> newChildDescriptors;

			/**
			 * The domain in which to create the children.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected EditingDomain editingDomain;

			/**
			 * Creates the a switch for populating child descriptors in the given domain.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) 
			{
				this.newChildDescriptors = newChildDescriptors;
				this.editingDomain = editingDomain;
			}
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseTaskPkg(TaskPkg object)
			{
				newChildDescriptors.add
					(createChildParameter
						(ProcessPackage.Literals.TASK_PKG__TASKS,
						 NuklearFactory.eINSTANCE.createNuklearPushConstants()));

				newChildDescriptors.add
					(createChildParameter
						(ProcessPackage.Literals.TASK_PKG__TASKS,
						 NuklearFactory.eINSTANCE.createNuklearLayoutTask()));

				newChildDescriptors.add
					(createChildParameter
						(ProcessPackage.Literals.TASK_PKG__TASKS,
						 NuklearFactory.eINSTANCE.createNuklearFillBufferTask()));

				return null;
			}
 
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseCompositeTask(CompositeTask object)
			{
				newChildDescriptors.add
					(createChildParameter
						(ProcessPackage.Literals.COMPOSITE_TASK__TASKS,
						 NuklearFactory.eINSTANCE.createNuklearPushConstants()));

				newChildDescriptors.add
					(createChildParameter
						(ProcessPackage.Literals.COMPOSITE_TASK__TASKS,
						 NuklearFactory.eINSTANCE.createNuklearLayoutTask()));

				newChildDescriptors.add
					(createChildParameter
						(ProcessPackage.Literals.COMPOSITE_TASK__TASKS,
						 NuklearFactory.eINSTANCE.createNuklearFillBufferTask()));

				return null;
			}
 
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected CommandParameter createChildParameter(Object feature, Object child)
			{
				return new CommandParameter(null, feature, child);
			}

		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain)
		{
			ArrayList<Object> result = new ArrayList<Object>();
			new CreationSwitch(result, editingDomain).doSwitch((EObject)object);
			return result;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public ResourceLocator getResourceLocator()
		{
			return ExtraEditPlugin.INSTANCE;
		}
	}

	/**
	 * A child creation extender for the {@link ResourcePackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class ResourceChildCreationExtender implements IChildCreationExtender
	{
		/**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected static class CreationSwitch extends ResourceSwitch<Object>
		{
			/**
			 * The child descriptors being populated.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected List<Object> newChildDescriptors;

			/**
			 * The domain in which to create the children.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected EditingDomain editingDomain;

			/**
			 * Creates the a switch for populating child descriptors in the given domain.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) 
			{
				this.newChildDescriptors = newChildDescriptors;
				this.editingDomain = editingDomain;
			}
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseBufferPart(BufferPart object)
			{
				newChildDescriptors.add
					(createChildParameter
						(ResourcePackage.Literals.BUFFER_PART__DATA_PROVIDER,
						 NuklearFactory.eINSTANCE.createNuklearVertexProvider()));

				newChildDescriptors.add
					(createChildParameter
						(ResourcePackage.Literals.BUFFER_PART__DATA_PROVIDER,
						 NuklearFactory.eINSTANCE.createNuklearIndexProvider()));

				return null;
			}
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected CommandParameter createChildParameter(Object feature, Object child)
			{
				return new CommandParameter(null, feature, child);
			}

		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain)
		{
			ArrayList<Object> result = new ArrayList<Object>();
			new CreationSwitch(result, editingDomain).doSwitch((EObject)object);
			return result;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public ResourceLocator getResourceLocator()
		{
			return ExtraEditPlugin.INSTANCE;
		}
	}

	/**
	 * A child creation extender for the {@link ApplicationPackage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class ApplicationChildCreationExtender implements IChildCreationExtender
	{
		/**
		 * The switch for creating child descriptors specific to each extended class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		protected static class CreationSwitch extends ApplicationSwitch<Object>
		{
			/**
			 * The child descriptors being populated.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected List<Object> newChildDescriptors;

			/**
			 * The domain in which to create the children.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected EditingDomain editingDomain;

			/**
			 * Creates the a switch for populating child descriptors in the given domain.
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) 
			{
				this.newChildDescriptors = newChildDescriptors;
				this.editingDomain = editingDomain;
			}
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			@Override
			public Object caseResourcePkg(ResourcePkg object)
			{
				newChildDescriptors.add
					(createChildParameter
						(ApplicationPackage.Literals.RESOURCE_PKG__RESOURCES,
						 NuklearFactory.eINSTANCE.createNuklearContext()));

				newChildDescriptors.add
					(createChildParameter
						(ApplicationPackage.Literals.RESOURCE_PKG__RESOURCES,
						 NuklearFactory.eINSTANCE.createNuklearFont()));

				return null;
			}
			/**
			 * <!-- begin-user-doc -->
			 * <!-- end-user-doc -->
			 * @generated
			 */
			protected CommandParameter createChildParameter(Object feature, Object child)
			{
				return new CommandParameter(null, feature, child);
			}

		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain)
		{
			ArrayList<Object> result = new ArrayList<Object>();
			new CreationSwitch(result, editingDomain).doSwitch((EObject)object);
			return result;
		}

		/**
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		@Override
		public ResourceLocator getResourceLocator()
		{
			return ExtraEditPlugin.INSTANCE;
		}
	}

}
