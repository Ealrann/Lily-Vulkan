/**
 */
package org.sheepy.vulkan.model.resource.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.sheepy.vulkan.model.resource.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.vulkan.model.resource.ResourcePackage
 * @generated
 */
public class ResourceAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ResourcePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = ResourcePackage.eINSTANCE;
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
	protected ResourceSwitch<Adapter> modelSwitch =
		new ResourceSwitch<Adapter>()
		{
			@Override
			public Adapter caseResource(Resource object)
			{
				return createResourceAdapter();
			}
			@Override
			public Adapter caseBasicResource(BasicResource object)
			{
				return createBasicResourceAdapter();
			}
			@Override
			public Adapter casePipelineResource(PipelineResource object)
			{
				return createPipelineResourceAdapter();
			}
			@Override
			public Adapter caseBuffer(Buffer object)
			{
				return createBufferAdapter();
			}
			@Override
			public Adapter caseImage(Image object)
			{
				return createImageAdapter();
			}
			@Override
			public Adapter caseImageLayout(ImageLayout object)
			{
				return createImageLayoutAdapter();
			}
			@Override
			public Adapter caseTexture(Texture object)
			{
				return createTextureAdapter();
			}
			@Override
			public Adapter casePushConstant(PushConstant object)
			{
				return createPushConstantAdapter();
			}
			@Override
			public Adapter caseIDescriptor(IDescriptor object)
			{
				return createIDescriptorAdapter();
			}
			@Override
			public Adapter caseDescriptorSet(DescriptorSet object)
			{
				return createDescriptorSetAdapter();
			}
			@Override
			public Adapter caseBasicDescriptorSet(BasicDescriptorSet object)
			{
				return createBasicDescriptorSetAdapter();
			}
			@Override
			public Adapter caseBarrier(Barrier object)
			{
				return createBarrierAdapter();
			}
			@Override
			public Adapter caseAbstractImageBarrier(AbstractImageBarrier object)
			{
				return createAbstractImageBarrierAdapter();
			}
			@Override
			public Adapter caseImageBarrier(ImageBarrier object)
			{
				return createImageBarrierAdapter();
			}
			@Override
			public Adapter caseReferenceImageBarrier(ReferenceImageBarrier object)
			{
				return createReferenceImageBarrierAdapter();
			}
			@Override
			public Adapter caseImageTransition(ImageTransition object)
			{
				return createImageTransitionAdapter();
			}
			@Override
			public Adapter caseShader(Shader object)
			{
				return createShaderAdapter();
			}
			@Override
			public Adapter caseIndexedBuffer(IndexedBuffer object)
			{
				return createIndexedBufferAdapter();
			}
			@Override
			public Adapter caseDepthImage(DepthImage object)
			{
				return createDepthImageAdapter();
			}
			@Override
			public Adapter casePathResource(PathResource object)
			{
				return createPathResourceAdapter();
			}
			@Override
			public Adapter caseFileResource(FileResource object)
			{
				return createFileResourceAdapter();
			}
			@Override
			public Adapter caseModuleResource(ModuleResource object)
			{
				return createModuleResourceAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.BasicResource <em>Basic Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.BasicResource
	 * @generated
	 */
	public Adapter createBasicResourceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.PipelineResource <em>Pipeline Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.PipelineResource
	 * @generated
	 */
	public Adapter createPipelineResourceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.Buffer <em>Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.Buffer
	 * @generated
	 */
	public Adapter createBufferAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.Image
	 * @generated
	 */
	public Adapter createImageAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.ImageLayout <em>Image Layout</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.ImageLayout
	 * @generated
	 */
	public Adapter createImageLayoutAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.Texture <em>Texture</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.Texture
	 * @generated
	 */
	public Adapter createTextureAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.PushConstant <em>Push Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.PushConstant
	 * @generated
	 */
	public Adapter createPushConstantAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.IDescriptor <em>IDescriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.IDescriptor
	 * @generated
	 */
	public Adapter createIDescriptorAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.DescriptorSet <em>Descriptor Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.DescriptorSet
	 * @generated
	 */
	public Adapter createDescriptorSetAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.BasicDescriptorSet <em>Basic Descriptor Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.BasicDescriptorSet
	 * @generated
	 */
	public Adapter createBasicDescriptorSetAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.Barrier <em>Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.Barrier
	 * @generated
	 */
	public Adapter createBarrierAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.AbstractImageBarrier <em>Abstract Image Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.AbstractImageBarrier
	 * @generated
	 */
	public Adapter createAbstractImageBarrierAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.ImageBarrier <em>Image Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.ImageBarrier
	 * @generated
	 */
	public Adapter createImageBarrierAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.ReferenceImageBarrier <em>Reference Image Barrier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.ReferenceImageBarrier
	 * @generated
	 */
	public Adapter createReferenceImageBarrierAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.ImageTransition <em>Image Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.ImageTransition
	 * @generated
	 */
	public Adapter createImageTransitionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.Shader <em>Shader</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.Shader
	 * @generated
	 */
	public Adapter createShaderAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.IndexedBuffer <em>Indexed Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.IndexedBuffer
	 * @generated
	 */
	public Adapter createIndexedBufferAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.DepthImage <em>Depth Image</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.DepthImage
	 * @generated
	 */
	public Adapter createDepthImageAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.PathResource <em>Path Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.PathResource
	 * @generated
	 */
	public Adapter createPathResourceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.FileResource <em>File Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.FileResource
	 * @generated
	 */
	public Adapter createFileResourceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.vulkan.model.resource.ModuleResource <em>Module Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.vulkan.model.resource.ModuleResource
	 * @generated
	 */
	public Adapter createModuleResourceAdapter()
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

} //ResourceAdapterFactory
