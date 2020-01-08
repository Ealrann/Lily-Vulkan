/**
 */
package org.sheepy.lily.vulkan.model.binding.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.lily.vulkan.model.binding.*;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.IProcessExtension;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.binding.BindingPackage
 * @generated
 */
public class BindingAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BindingPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = BindingPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object)
	{
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BindingSwitch<Adapter> modelSwitch =
		new BindingSwitch<Adapter>()
		{
			@Override
			public Adapter caseBindingConfiguration(BindingConfiguration object)
			{
				return createBindingConfigurationAdapter();
			}
			@Override
			public Adapter caseConfigureBind(ConfigureBind object)
			{
				return createConfigureBindAdapter();
			}
			@Override
			public Adapter caseRotateConfiguration(RotateConfiguration object)
			{
				return createRotateConfigurationAdapter();
			}
			@Override
			public Adapter caseIConfigurationTask(IConfigurationTask object)
			{
				return createIConfigurationTaskAdapter();
			}
			@Override
			public Adapter caseConfigurePrepareComposite(ConfigurePrepareComposite object)
			{
				return createConfigurePrepareCompositeAdapter();
			}
			@Override
			public Adapter caseConfigureBufferDescriptor(ConfigureBufferDescriptor object)
			{
				return createConfigureBufferDescriptorAdapter();
			}
			@Override
			public Adapter caseConfigureCompositeBufferBarrier(ConfigureCompositeBufferBarrier object)
			{
				return createConfigureCompositeBufferBarrierAdapter();
			}
			@Override
			public Adapter caseIContextConfiguration(IContextConfiguration object)
			{
				return createIContextConfigurationAdapter();
			}
			@Override
			public Adapter caseIndexConfiguration(IndexConfiguration object)
			{
				return createIndexConfigurationAdapter();
			}
			@Override
			public Adapter caseLNamedElement(LNamedElement object)
			{
				return createLNamedElementAdapter();
			}
			@Override
			public Adapter caseIProcessExtension(IProcessExtension object)
			{
				return createIProcessExtensionAdapter();
			}
			@Override
			public Adapter caseIPipelineTask(IPipelineTask object)
			{
				return createIPipelineTaskAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object)
			{
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target)
	{
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.binding.BindingConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.binding.BindingConfiguration
	 * @generated
	 */
	public Adapter createBindingConfigurationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.binding.ConfigureBind <em>Configure Bind</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigureBind
	 * @generated
	 */
	public Adapter createConfigureBindAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.binding.RotateConfiguration <em>Rotate Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.binding.RotateConfiguration
	 * @generated
	 */
	public Adapter createRotateConfigurationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.binding.IConfigurationTask <em>IConfiguration Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.binding.IConfigurationTask
	 * @generated
	 */
	public Adapter createIConfigurationTaskAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite <em>Configure Prepare Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigurePrepareComposite
	 * @generated
	 */
	public Adapter createConfigurePrepareCompositeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor <em>Configure Buffer Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigureBufferDescriptor
	 * @generated
	 */
	public Adapter createConfigureBufferDescriptorAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier <em>Configure Composite Buffer Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.binding.ConfigureCompositeBufferBarrier
	 * @generated
	 */
	public Adapter createConfigureCompositeBufferBarrierAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.binding.IContextConfiguration <em>IContext Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.binding.IContextConfiguration
	 * @generated
	 */
	public Adapter createIContextConfigurationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.binding.IndexConfiguration <em>Index Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.binding.IndexConfiguration
	 * @generated
	 */
	public Adapter createIndexConfigurationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.types.LNamedElement <em>LNamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.types.LNamedElement
	 * @generated
	 */
	public Adapter createLNamedElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.IProcessExtension <em>IProcess Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.IProcessExtension
	 * @generated
	 */
	public Adapter createIProcessExtensionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.IPipelineTask <em>IPipeline Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.IPipelineTask
	 * @generated
	 */
	public Adapter createIPipelineTaskAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter()
	{
		return null;
	}

} //BindingAdapterFactory