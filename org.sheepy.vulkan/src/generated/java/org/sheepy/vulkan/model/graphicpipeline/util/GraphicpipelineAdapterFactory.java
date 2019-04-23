/**
 */
package org.sheepy.vulkan.model.graphicpipeline.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.vulkan.model.graphicpipeline.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage
 * @generated
 */
public class GraphicpipelineAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GraphicpipelinePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicpipelineAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = GraphicpipelinePackage.eINSTANCE;
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
	protected GraphicpipelineSwitch<Adapter> modelSwitch = new GraphicpipelineSwitch<Adapter>()
	{
		@Override
		public Adapter caseColorBlend(ColorBlend object)
		{
			return createColorBlendAdapter();
		}
		@Override
		public Adapter caseColorBlendAttachment(ColorBlendAttachment object)
		{
			return createColorBlendAttachmentAdapter();
		}
		@Override
		public Adapter caseInputAssembly(InputAssembly object)
		{
			return createInputAssemblyAdapter();
		}
		@Override
		public Adapter caseRasterizer(Rasterizer object)
		{
			return createRasterizerAdapter();
		}
		@Override
		public Adapter caseDynamicState(DynamicState object)
		{
			return createDynamicStateAdapter();
		}
		@Override
		public Adapter caseViewportState(ViewportState object)
		{
			return createViewportStateAdapter();
		}
		@Override
		public Adapter caseStaticViewportState(StaticViewportState object)
		{
			return createStaticViewportStateAdapter();
		}
		@Override
		public Adapter caseDynamicViewportState(DynamicViewportState object)
		{
			return createDynamicViewportStateAdapter();
		}
		@Override
		public Adapter caseVec2I(Vec2I object)
		{
			return createVec2IAdapter();
		}
		@Override
		public Adapter caseViewport(Viewport object)
		{
			return createViewportAdapter();
		}
		@Override
		public Adapter caseScissor(Scissor object)
		{
			return createScissorAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlend <em>Color Blend</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlend
	 * @generated
	 */
	public Adapter createColorBlendAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment <em>Color Blend Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment
	 * @generated
	 */
	public Adapter createColorBlendAttachmentAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.graphicpipeline.InputAssembly <em>Input Assembly</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.graphicpipeline.InputAssembly
	 * @generated
	 */
	public Adapter createInputAssemblyAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.graphicpipeline.Rasterizer <em>Rasterizer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Rasterizer
	 * @generated
	 */
	public Adapter createRasterizerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.graphicpipeline.DynamicState <em>Dynamic State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.graphicpipeline.DynamicState
	 * @generated
	 */
	public Adapter createDynamicStateAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.graphicpipeline.ViewportState <em>Viewport State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.graphicpipeline.ViewportState
	 * @generated
	 */
	public Adapter createViewportStateAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.graphicpipeline.StaticViewportState <em>Static Viewport State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.graphicpipeline.StaticViewportState
	 * @generated
	 */
	public Adapter createStaticViewportStateAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState <em>Dynamic Viewport State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState
	 * @generated
	 */
	public Adapter createDynamicViewportStateAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.graphicpipeline.Vec2I <em>Vec2 I</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Vec2I
	 * @generated
	 */
	public Adapter createVec2IAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.graphicpipeline.Viewport <em>Viewport</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Viewport
	 * @generated
	 */
	public Adapter createViewportAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.graphicpipeline.Scissor <em>Scissor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.graphicpipeline.Scissor
	 * @generated
	 */
	public Adapter createScissorAdapter()
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

} //GraphicpipelineAdapterFactory
