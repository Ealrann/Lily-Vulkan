/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.vulkan.extra.model.sprite.*;
import org.sheepy.lily.vulkan.model.process.IPipelineExtension;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage
 * @generated
 */
public class SpriteAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SpritePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpriteAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = SpritePackage.eINSTANCE;
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
	protected SpriteSwitch<Adapter> modelSwitch =
		new SpriteSwitch<Adapter>()
		{
			@Override
			public Adapter caseSpriteExtension(SpriteExtension object)
			{
				return createSpriteExtensionAdapter();
			}
			@Override
			public Adapter caseISpriteDataSource(ISpriteDataSource object)
			{
				return createISpriteDataSourceAdapter();
			}
			@Override
			public Adapter caseIPipelineExtension(IPipelineExtension object)
			{
				return createIPipelineExtensionAdapter();
			}
			@Override
			public Adapter caseIBufferDataSource(IBufferDataSource object)
			{
				return createIBufferDataSourceAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension
	 * @generated
	 */
	public Adapter createSpriteExtensionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.sprite.ISpriteDataSource <em>ISprite Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.sprite.ISpriteDataSource
	 * @generated
	 */
	public Adapter createISpriteDataSourceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource <em>IBuffer Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource
	 * @generated
	 */
	public Adapter createIBufferDataSourceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.IPipelineExtension <em>IPipeline Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.IPipelineExtension
	 * @generated
	 */
	public Adapter createIPipelineExtensionAdapter()
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

} //SpriteAdapterFactory
