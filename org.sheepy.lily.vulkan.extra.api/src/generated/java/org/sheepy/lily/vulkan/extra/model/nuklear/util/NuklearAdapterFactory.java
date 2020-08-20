/**
 */
package org.sheepy.lily.vulkan.extra.model.nuklear.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.model.inference.IInferenceObject;
import org.sheepy.lily.core.model.presentation.IPositionElement;
import org.sheepy.lily.core.model.presentation.ISizedElement;
import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.lily.core.model.ui.IPanel;
import org.sheepy.lily.core.model.ui.IUIElement;
import org.sheepy.lily.core.model.ui.Panel;
import org.sheepy.lily.vulkan.extra.model.nuklear.*;
import org.sheepy.lily.vulkan.model.IVulkanResource;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.PushConstant;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDataProvider;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPackage
 * @generated
 */
public class NuklearAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static NuklearPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NuklearAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = NuklearPackage.eINSTANCE;
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
	protected NuklearSwitch<Adapter> modelSwitch =
		new NuklearSwitch<Adapter>()
		{
			@Override
			public Adapter caseNuklearPushConstants(NuklearPushConstants object)
			{
				return createNuklearPushConstantsAdapter();
			}
			@Override
			public Adapter caseNuklearContext(NuklearContext object)
			{
				return createNuklearContextAdapter();
			}
			@Override
			public Adapter caseNuklearFont(NuklearFont object)
			{
				return createNuklearFontAdapter();
			}
			@Override
			public Adapter caseSelectorPanel(SelectorPanel object)
			{
				return createSelectorPanelAdapter();
			}
			@Override
			public Adapter caseIInputProvider(IInputProvider object)
			{
				return createIInputProviderAdapter();
			}
			@Override
			public Adapter casePanelViewer(PanelViewer object)
			{
				return createPanelViewerAdapter();
			}
			@Override
			public Adapter caseNuklearVertexProvider(NuklearVertexProvider object)
			{
				return createNuklearVertexProviderAdapter();
			}
			@Override
			public Adapter caseNuklearIndexProvider(NuklearIndexProvider object)
			{
				return createNuklearIndexProviderAdapter();
			}
			@Override
			public Adapter caseFontImageProvider(FontImageProvider object)
			{
				return createFontImageProviderAdapter();
			}
			@Override
			public Adapter caseLNamedElement(LNamedElement object)
			{
				return createLNamedElementAdapter();
			}
			@Override
			public Adapter caseIPipelineTask(IPipelineTask object)
			{
				return createIPipelineTaskAdapter();
			}
			@Override
			public Adapter casePushConstant(PushConstant object)
			{
				return createPushConstantAdapter();
			}
			@Override
			public Adapter caseIVulkanResource(IVulkanResource object)
			{
				return createIVulkanResourceAdapter();
			}
			@Override
			public Adapter caseIInferenceObject(IInferenceObject object)
			{
				return createIInferenceObjectAdapter();
			}
			@Override
			public Adapter caseIUIElement(IUIElement object)
			{
				return createIUIElementAdapter();
			}
			@Override
			public Adapter caseIPositionElement(IPositionElement object)
			{
				return createIPositionElementAdapter();
			}
			@Override
			public Adapter caseIPanel(IPanel object)
			{
				return createIPanelAdapter();
			}
			@Override
			public Adapter caseISizedElement(ISizedElement object)
			{
				return createISizedElementAdapter();
			}
			@Override
			public Adapter casePanel(Panel object)
			{
				return createPanelAdapter();
			}
			@Override
			public Adapter caseBufferDataProvider(BufferDataProvider object)
			{
				return createBufferDataProviderAdapter();
			}
			@Override
			public Adapter caseImageDataProvider(ImageDataProvider object)
			{
				return createImageDataProviderAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants <em>Push Constants</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants
	 * @generated
	 */
	public Adapter createNuklearPushConstantsAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext
	 * @generated
	 */
	public Adapter createNuklearContextAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont <em>Font</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont
	 * @generated
	 */
	public Adapter createNuklearFontAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel <em>Selector Panel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel
	 * @generated
	 */
	public Adapter createSelectorPanelAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.nuklear.IInputProvider <em>IInput Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.IInputProvider
	 * @generated
	 */
	public Adapter createIInputProviderAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.nuklear.PanelViewer <em>Panel Viewer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.PanelViewer
	 * @generated
	 */
	public Adapter createPanelViewerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearVertexProvider <em>Vertex Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearVertexProvider
	 * @generated
	 */
	public Adapter createNuklearVertexProviderAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.nuklear.NuklearIndexProvider <em>Index Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.NuklearIndexProvider
	 * @generated
	 */
	public Adapter createNuklearIndexProviderAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.nuklear.FontImageProvider <em>Font Image Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.nuklear.FontImageProvider
	 * @generated
	 */
	public Adapter createFontImageProviderAdapter()
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
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.PushConstant <em>Push Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.PushConstant
	 * @generated
	 */
	public Adapter createPushConstantAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.IVulkanResource <em>IVulkan Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.IVulkanResource
	 * @generated
	 */
	public Adapter createIVulkanResourceAdapter()
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
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.ui.IUIElement <em>IUI Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.ui.IUIElement
	 * @generated
	 */
	public Adapter createIUIElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.presentation.IPositionElement <em>IPosition Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.presentation.IPositionElement
	 * @generated
	 */
	public Adapter createIPositionElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.ui.IPanel <em>IPanel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.ui.IPanel
	 * @generated
	 */
	public Adapter createIPanelAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.presentation.ISizedElement <em>ISized Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.presentation.ISizedElement
	 * @generated
	 */
	public Adapter createISizedElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.ui.Panel <em>Panel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.ui.Panel
	 * @generated
	 */
	public Adapter createPanelAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferDataProvider <em>Buffer Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.BufferDataProvider
	 * @generated
	 */
	public Adapter createBufferDataProviderAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.vulkanresource.ImageDataProvider <em>Image Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ImageDataProvider
	 * @generated
	 */
	public Adapter createImageDataProviderAdapter()
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

} //NuklearAdapterFactory
