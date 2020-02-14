/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.sheepy.lily.core.api.adapter.LilyEObject;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentDescriptor;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;

import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attachment Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentDescriptorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentDescriptorImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentDescriptorImpl#getShaderStages <em>Shader Stages</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentDescriptorImpl#getAttachment <em>Attachment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttachmentDescriptorImpl extends LilyEObject implements AttachmentDescriptor
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
	 * The cached value of the '{@link #getAttachment() <em>Attachment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttachment()
	 * @generated
	 * @ordered
	 */
	protected ExtraAttachment attachment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttachmentDescriptorImpl()
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
		return GraphicPackage.Literals.ATTACHMENT_DESCRIPTOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.ATTACHMENT_DESCRIPTOR__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.ATTACHMENT_DESCRIPTOR__TYPE, oldType, type));
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
			shaderStages = new EDataTypeUniqueEList<EShaderStage>(EShaderStage.class, this, GraphicPackage.ATTACHMENT_DESCRIPTOR__SHADER_STAGES);
		}
		return shaderStages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExtraAttachment getAttachment()
	{
		if (attachment != null && ((EObject)attachment).eIsProxy())
		{
			InternalEObject oldAttachment = attachment;
			attachment = (ExtraAttachment)eResolveProxy(oldAttachment);
			if (attachment != oldAttachment)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphicPackage.ATTACHMENT_DESCRIPTOR__ATTACHMENT, oldAttachment, attachment));
			}
		}
		return attachment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtraAttachment basicGetAttachment()
	{
		return attachment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAttachment(ExtraAttachment newAttachment)
	{
		ExtraAttachment oldAttachment = attachment;
		attachment = newAttachment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.ATTACHMENT_DESCRIPTOR__ATTACHMENT, oldAttachment, attachment));
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
			case GraphicPackage.ATTACHMENT_DESCRIPTOR__NAME:
				return getName();
			case GraphicPackage.ATTACHMENT_DESCRIPTOR__TYPE:
				return getType();
			case GraphicPackage.ATTACHMENT_DESCRIPTOR__SHADER_STAGES:
				return getShaderStages();
			case GraphicPackage.ATTACHMENT_DESCRIPTOR__ATTACHMENT:
				if (resolve) return getAttachment();
				return basicGetAttachment();
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
			case GraphicPackage.ATTACHMENT_DESCRIPTOR__NAME:
				setName((String)newValue);
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTOR__TYPE:
				setType((EDescriptorType)newValue);
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTOR__SHADER_STAGES:
				getShaderStages().clear();
				getShaderStages().addAll((Collection<? extends EShaderStage>)newValue);
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTOR__ATTACHMENT:
				setAttachment((ExtraAttachment)newValue);
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
			case GraphicPackage.ATTACHMENT_DESCRIPTOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTOR__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTOR__SHADER_STAGES:
				getShaderStages().clear();
				return;
			case GraphicPackage.ATTACHMENT_DESCRIPTOR__ATTACHMENT:
				setAttachment((ExtraAttachment)null);
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
			case GraphicPackage.ATTACHMENT_DESCRIPTOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GraphicPackage.ATTACHMENT_DESCRIPTOR__TYPE:
				return type != TYPE_EDEFAULT;
			case GraphicPackage.ATTACHMENT_DESCRIPTOR__SHADER_STAGES:
				return shaderStages != null && !shaderStages.isEmpty();
			case GraphicPackage.ATTACHMENT_DESCRIPTOR__ATTACHMENT:
				return attachment != null;
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
		result.append(')');
		return result.toString();
	}

} //AttachmentDescriptorImpl
