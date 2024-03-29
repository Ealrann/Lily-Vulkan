/**
 */
package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.Sampler;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourcePackage;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Image Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageDescriptorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageDescriptorImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageDescriptorImpl#getShaderStages <em>Shader Stages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageDescriptorImpl#getImages <em>Images</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageDescriptorImpl#getSampler <em>Sampler</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageDescriptorImpl#getLayout <em>Layout</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImageDescriptorImpl extends LilyEObject implements ImageDescriptor
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
	protected EList<IVulkanImage> images;

	/**
	 * The cached value of the '{@link #getSampler() <em>Sampler</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSampler()
	 * @generated
	 * @ordered
	 */
	protected Sampler sampler;

	/**
	 * The default value of the '{@link #getLayout() <em>Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayout()
	 * @generated
	 * @ordered
	 */
	protected static final EImageLayout LAYOUT_EDEFAULT = EImageLayout.GENERAL;

	/**
	 * The cached value of the '{@link #getLayout() <em>Layout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayout()
	 * @generated
	 * @ordered
	 */
	protected EImageLayout layout = LAYOUT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImageDescriptorImpl()
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
		return VulkanResourcePackage.Literals.IMAGE_DESCRIPTOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.IMAGE_DESCRIPTOR__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.IMAGE_DESCRIPTOR__TYPE, oldType, type));
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
			shaderStages = new EDataTypeUniqueEList<>(EShaderStage.class, this, VulkanResourcePackage.IMAGE_DESCRIPTOR__SHADER_STAGES);
		}
		return shaderStages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IVulkanImage> getImages()
	{
		if (images == null)
		{
			images = new EObjectResolvingEList<>(IVulkanImage.class, this, VulkanResourcePackage.IMAGE_DESCRIPTOR__IMAGES);
		}
		return images;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Sampler getSampler()
	{
		if (sampler != null && ((EObject)sampler).eIsProxy())
		{
			InternalEObject oldSampler = sampler;
			sampler = (Sampler)eResolveProxy(oldSampler);
			if (sampler != oldSampler)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VulkanResourcePackage.IMAGE_DESCRIPTOR__SAMPLER, oldSampler, sampler));
			}
		}
		return sampler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sampler basicGetSampler()
	{
		return sampler;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSampler(Sampler newSampler)
	{
		Sampler oldSampler = sampler;
		sampler = newSampler;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.IMAGE_DESCRIPTOR__SAMPLER, oldSampler, sampler));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EImageLayout getLayout()
	{
		return layout;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLayout(EImageLayout newLayout)
	{
		EImageLayout oldLayout = layout;
		layout = newLayout == null ? LAYOUT_EDEFAULT : newLayout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.IMAGE_DESCRIPTOR__LAYOUT, oldLayout, layout));
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
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__NAME:
				return getName();
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__TYPE:
				return getType();
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__SHADER_STAGES:
				return getShaderStages();
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__IMAGES:
				return getImages();
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__SAMPLER:
				if (resolve) return getSampler();
				return basicGetSampler();
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__LAYOUT:
				return getLayout();
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
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__NAME:
				setName((String)newValue);
				return;
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__TYPE:
				setType((EDescriptorType)newValue);
				return;
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__SHADER_STAGES:
				getShaderStages().clear();
				getShaderStages().addAll((Collection<? extends EShaderStage>)newValue);
				return;
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__IMAGES:
				getImages().clear();
				getImages().addAll((Collection<? extends IVulkanImage>)newValue);
				return;
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__SAMPLER:
				setSampler((Sampler)newValue);
				return;
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__LAYOUT:
				setLayout((EImageLayout)newValue);
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
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__SHADER_STAGES:
				getShaderStages().clear();
				return;
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__IMAGES:
				getImages().clear();
				return;
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__SAMPLER:
				setSampler((Sampler)null);
				return;
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__LAYOUT:
				setLayout(LAYOUT_EDEFAULT);
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
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__TYPE:
				return type != TYPE_EDEFAULT;
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__SHADER_STAGES:
				return shaderStages != null && !shaderStages.isEmpty();
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__IMAGES:
				return images != null && !images.isEmpty();
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__SAMPLER:
				return sampler != null;
			case VulkanResourcePackage.IMAGE_DESCRIPTOR__LAYOUT:
				return layout != LAYOUT_EDEFAULT;
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
		result.append(", layout: ");
		result.append(layout);
		result.append(')');
		return result.toString();
	}

} //ImageDescriptorImpl
