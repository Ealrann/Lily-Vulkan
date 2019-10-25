/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.lily.vulkan.extra.model.sprite.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpriteFactoryImpl extends EFactoryImpl implements SpriteFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SpriteFactory init()
	{
		try
		{
			SpriteFactory theSpriteFactory = (SpriteFactory)EPackage.Registry.INSTANCE.getEFactory(SpritePackage.eNS_URI);
			if (theSpriteFactory != null)
			{
				return theSpriteFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SpriteFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpriteFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case SpritePackage.SPRITE_RENDERER: return createSpriteRenderer();
			case SpritePackage.SPRITE: return createSprite();
			case SpritePackage.SPRITE_MONO_SAMPLER_PROVIDER: return createSpriteMonoSamplerProvider();
			case SpritePackage.SPRITE_STRUCTURE: return createSpriteStructure();
			case SpritePackage.SPRITE_COUNT_SPECIALIZATION: return createSpriteCountSpecialization();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue)
	{
		switch (eDataType.getClassifierID())
		{
			case SpritePackage.SPRITE_TYPE:
				return createSpriteTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue)
	{
		switch (eDataType.getClassifierID())
		{
			case SpritePackage.SPRITE_TYPE:
				return convertSpriteTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpriteRenderer createSpriteRenderer()
	{
		SpriteRendererImpl spriteRenderer = new SpriteRendererImpl();
		return spriteRenderer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Sprite createSprite()
	{
		SpriteImpl sprite = new SpriteImpl();
		return sprite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpriteMonoSamplerProvider createSpriteMonoSamplerProvider()
	{
		SpriteMonoSamplerProviderImpl spriteMonoSamplerProvider = new SpriteMonoSamplerProviderImpl();
		return spriteMonoSamplerProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpriteStructure createSpriteStructure()
	{
		SpriteStructureImpl spriteStructure = new SpriteStructureImpl();
		return spriteStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpriteCountSpecialization createSpriteCountSpecialization()
	{
		SpriteCountSpecializationImpl spriteCountSpecialization = new SpriteCountSpecializationImpl();
		return spriteCountSpecialization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpriteType createSpriteTypeFromString(EDataType eDataType, String initialValue)
	{
		SpriteType result = SpriteType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSpriteTypeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SpritePackage getSpritePackage()
	{
		return (SpritePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SpritePackage getPackage()
	{
		return SpritePackage.eINSTANCE;
	}

} //SpriteFactoryImpl
