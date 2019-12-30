/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.core.model.application.IImage;
import org.sheepy.lily.vulkan.model.resource.ImageArrayDescriptor;
import org.sheepy.lily.vulkan.model.resource.ResourcePackage;

import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Image Array Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.ImageArrayDescriptorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.ImageArrayDescriptorImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.ImageArrayDescriptorImpl#getShaderStages <em>Shader Stages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.ImageArrayDescriptorImpl#getImages <em>Images</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.ImageArrayDescriptorImpl#getInitialLayout <em>Initial Layout</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImageArrayDescriptorImpl extends LilyEObject implements ImageArrayDescriptor
{
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final EDescriptorType TYPE_EDEFAULT = EDescriptorType.SAMPLER;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EDescriptorType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getShaderStages() <em>Shader Stages</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getShaderStages()
	 * @generated
	 * @ordered
	 */
	protected EList<EShaderStage> shaderStages;

	/**
	 * The cached value of the '{@link #getImages() <em>Images</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImages()
	 * @generated
	 * @ordered
	 */
	protected EList<IImage> images;

	/**
	 * The default value of the '{@link #getInitialLayout() <em>Initial Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialLayout()
	 * @generated
	 * @ordered
	 */
	protected static final EImageLayout INITIAL_LAYOUT_EDEFAULT = EImageLayout.UNDEFINED;

	/**
	 * The cached value of the '{@link #getInitialLayout() <em>Initial Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialLayout()
	 * @generated
	 * @ordered
	 */
	protected EImageLayout initialLayout = INITIAL_LAYOUT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImageArrayDescriptorImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return ResourcePackage.Literals.IMAGE_ARRAY_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName()
	{
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName)
	{
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDescriptorType getType()
	{
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(EDescriptorType newType)
	{
		EDescriptorType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EShaderStage> getShaderStages()
	{
		if (shaderStages == null)
		{
			shaderStages = new EDataTypeUniqueEList<EShaderStage>(EShaderStage.class, this, ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__SHADER_STAGES);
		}
		return shaderStages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IImage> getImages()
	{
		if (images == null)
		{
			images = new EObjectResolvingEList<IImage>(IImage.class, this, ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__IMAGES);
		}
		return images;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EImageLayout getInitialLayout()
	{
		return initialLayout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInitialLayout(EImageLayout newInitialLayout)
	{
		EImageLayout oldInitialLayout = initialLayout;
		initialLayout = newInitialLayout == null ? INITIAL_LAYOUT_EDEFAULT : newInitialLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__INITIAL_LAYOUT, oldInitialLayout, initialLayout));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__NAME:
				return getName();
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__TYPE:
				return getType();
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__SHADER_STAGES:
				return getShaderStages();
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__IMAGES:
				return getImages();
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__INITIAL_LAYOUT:
				return getInitialLayout();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__NAME:
				setName((String)newValue);
				return;
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__TYPE:
				setType((EDescriptorType)newValue);
				return;
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__SHADER_STAGES:
				getShaderStages().clear();
				getShaderStages().addAll((Collection<? extends EShaderStage>)newValue);
				return;
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__IMAGES:
				getImages().clear();
				getImages().addAll((Collection<? extends IImage>)newValue);
				return;
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__INITIAL_LAYOUT:
				setInitialLayout((EImageLayout)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__SHADER_STAGES:
				getShaderStages().clear();
				return;
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__IMAGES:
				getImages().clear();
				return;
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__INITIAL_LAYOUT:
				setInitialLayout(INITIAL_LAYOUT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__TYPE:
				return type != TYPE_EDEFAULT;
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__SHADER_STAGES:
				return shaderStages != null && !shaderStages.isEmpty();
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__IMAGES:
				return images != null && !images.isEmpty();
			case ResourcePackage.IMAGE_ARRAY_DESCRIPTOR__INITIAL_LAYOUT:
				return initialLayout != INITIAL_LAYOUT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(", shaderStages: ");
		result.append(shaderStages);
		result.append(", initialLayout: ");
		result.append(initialLayout);
		result.append(')');
		return result.toString();
	}

} //ImageArrayDescriptorImpl
