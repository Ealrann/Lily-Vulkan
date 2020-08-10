/**
 */
package org.sheepy.lily.vulkan.model.resource.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.sheepy.lily.core.model.variable.IModelVariable;

import org.sheepy.lily.core.model.variable.ModelVariablePkg;
import org.sheepy.lily.vulkan.model.resource.GenericConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Constant Buffer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.GenericConstantBufferImpl#getReferencedVariables <em>Referenced Variables</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.resource.impl.GenericConstantBufferImpl#getVariablePkg <em>Variable Pkg</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GenericConstantBufferImpl extends ConstantBufferImpl implements GenericConstantBuffer
{
	/**
	 * The cached value of the '{@link #getReferencedVariables() <em>Referenced Variables</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferencedVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<IModelVariable> referencedVariables;

	/**
	 * The cached value of the '{@link #getVariablePkg() <em>Variable Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariablePkg()
	 * @generated
	 * @ordered
	 */
	protected ModelVariablePkg variablePkg;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenericConstantBufferImpl()
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
		return VulkanResourcePackage.Literals.GENERIC_CONSTANT_BUFFER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IModelVariable> getReferencedVariables()
	{
		if (referencedVariables == null) {
			referencedVariables = new EObjectResolvingEList<IModelVariable>(IModelVariable.class, this, VulkanResourcePackage.GENERIC_CONSTANT_BUFFER__REFERENCED_VARIABLES);
		}
		return referencedVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelVariablePkg getVariablePkg()
	{
		return variablePkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariablePkg(ModelVariablePkg newVariablePkg, NotificationChain msgs)
	{
		ModelVariablePkg oldVariablePkg = variablePkg;
		variablePkg = newVariablePkg;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.GENERIC_CONSTANT_BUFFER__VARIABLE_PKG, oldVariablePkg, newVariablePkg);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVariablePkg(ModelVariablePkg newVariablePkg)
	{
		if (newVariablePkg != variablePkg) {
			NotificationChain msgs = null;
			if (variablePkg != null)
				msgs = ((InternalEObject)variablePkg).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VulkanResourcePackage.GENERIC_CONSTANT_BUFFER__VARIABLE_PKG, null, msgs);
			if (newVariablePkg != null)
				msgs = ((InternalEObject)newVariablePkg).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VulkanResourcePackage.GENERIC_CONSTANT_BUFFER__VARIABLE_PKG, null, msgs);
			msgs = basicSetVariablePkg(newVariablePkg, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VulkanResourcePackage.GENERIC_CONSTANT_BUFFER__VARIABLE_PKG, newVariablePkg, newVariablePkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case VulkanResourcePackage.GENERIC_CONSTANT_BUFFER__VARIABLE_PKG:
				return basicSetVariablePkg(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID) {
			case VulkanResourcePackage.GENERIC_CONSTANT_BUFFER__REFERENCED_VARIABLES:
				return getReferencedVariables();
			case VulkanResourcePackage.GENERIC_CONSTANT_BUFFER__VARIABLE_PKG:
				return getVariablePkg();
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
		switch (featureID) {
			case VulkanResourcePackage.GENERIC_CONSTANT_BUFFER__REFERENCED_VARIABLES:
				getReferencedVariables().clear();
				getReferencedVariables().addAll((Collection<? extends IModelVariable>)newValue);
				return;
			case VulkanResourcePackage.GENERIC_CONSTANT_BUFFER__VARIABLE_PKG:
				setVariablePkg((ModelVariablePkg)newValue);
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
		switch (featureID) {
			case VulkanResourcePackage.GENERIC_CONSTANT_BUFFER__REFERENCED_VARIABLES:
				getReferencedVariables().clear();
				return;
			case VulkanResourcePackage.GENERIC_CONSTANT_BUFFER__VARIABLE_PKG:
				setVariablePkg((ModelVariablePkg)null);
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
		switch (featureID) {
			case VulkanResourcePackage.GENERIC_CONSTANT_BUFFER__REFERENCED_VARIABLES:
				return referencedVariables != null && !referencedVariables.isEmpty();
			case VulkanResourcePackage.GENERIC_CONSTANT_BUFFER__VARIABLE_PKG:
				return variablePkg != null;
		}
		return super.eIsSet(featureID);
	}

} //GenericConstantBufferImpl
