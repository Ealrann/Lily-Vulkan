/**
 */
package org.sheepy.lily.vulkan.model.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.root.LObject;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.vulkan.model.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.model.VulkanPackage
 * @generated
 */
public class VulkanAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static VulkanPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VulkanAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = VulkanPackage.eINSTANCE;
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
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VulkanSwitch<Adapter> modelSwitch = new VulkanSwitch<Adapter>()
	{
		@Override
		public Adapter caseVulkanEngine(VulkanEngine object)
		{
			return createVulkanEngineAdapter();
		}

		@Override
		public Adapter caseIResourceContainer(IResourceContainer object)
		{
			return createIResourceContainerAdapter();
		}

		@Override
		public Adapter caseResourcePkg(ResourcePkg object)
		{
			return createResourcePkgAdapter();
		}

		@Override
		public Adapter caseIResource(IResource object)
		{
			return createIResourceAdapter();
		}

		@Override
		public Adapter caseIProcess(IProcess object)
		{
			return createIProcessAdapter();
		}

		@Override
		public Adapter caseIExecutionManager(IExecutionManager object)
		{
			return createIExecutionManagerAdapter();
		}

		@Override
		public Adapter caseColorDomain(ColorDomain object)
		{
			return createColorDomainAdapter();
		}

		@Override
		public Adapter caseIInferenceObject(IInferenceObject object)
		{
			return createIInferenceObjectAdapter();
		}

		@Override
		public Adapter caseLObject(LObject object)
		{
			return createLObjectAdapter();
		}

		@Override
		public Adapter caseIEngine(IEngine object)
		{
			return createIEngineAdapter();
		}

		@Override
		public Adapter caseLNamedElement(LNamedElement object)
		{
			return createLNamedElementAdapter();
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
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.VulkanEngine <em>Engine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.VulkanEngine
	 * @generated
	 */
	public Adapter createVulkanEngineAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.IResourceContainer <em>IResource Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.IResourceContainer
	 * @generated
	 */
	public Adapter createIResourceContainerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.ResourcePkg <em>Resource Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.ResourcePkg
	 * @generated
	 */
	public Adapter createResourcePkgAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.IResource <em>IResource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.IResource
	 * @generated
	 */
	public Adapter createIResourceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.IProcess <em>IProcess</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.IProcess
	 * @generated
	 */
	public Adapter createIProcessAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.IExecutionManager <em>IExecution Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.IExecutionManager
	 * @generated
	 */
	public Adapter createIExecutionManagerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.ColorDomain <em>Color Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.ColorDomain
	 * @generated
	 */
	public Adapter createColorDomainAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.inference.IInferenceObject <em>IInference Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.inference.IInferenceObject
	 * @generated
	 */
	public Adapter createIInferenceObjectAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.root.LObject <em>LObject</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.root.LObject
	 * @generated
	 */
	public Adapter createLObjectAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.application.IEngine <em>IEngine</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.application.IEngine
	 * @generated
	 */
	public Adapter createIEngineAdapter()
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

} //VulkanAdapterFactory
