/**
 */
package org.sheepy.lily.vulkan.model.process.compute.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.compute.ComputePackage;

import org.sheepy.lily.vulkan.model.process.impl.ProcessExecutionManagerImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.impl.ComputeExecutionManagerImpl#getRecorders <em>Recorders</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.compute.impl.ComputeExecutionManagerImpl#getIndexCount <em>Index Count</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComputeExecutionManagerImpl extends ProcessExecutionManagerImpl implements ComputeExecutionManager
{
	/**
	 * The cached value of the '{@link #getRecorders() <em>Recorders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecorders()
	 * @generated
	 * @ordered
	 */
	protected EList<ComputeExecutionRecorder> recorders;

	/**
	 * The default value of the '{@link #getIndexCount() <em>Index Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexCount()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_COUNT_EDEFAULT = 1;
	/**
	 * The cached value of the '{@link #getIndexCount() <em>Index Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexCount()
	 * @generated
	 * @ordered
	 */
	protected int indexCount = INDEX_COUNT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputeExecutionManagerImpl()
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
		return ComputePackage.Literals.COMPUTE_EXECUTION_MANAGER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ComputeExecutionRecorder> getRecorders()
	{
		if (recorders == null) {
			recorders = new EObjectContainmentEList<ComputeExecutionRecorder>(ComputeExecutionRecorder.class, this, ComputePackage.COMPUTE_EXECUTION_MANAGER__RECORDERS);
		}
		return recorders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getIndexCount()
	{
		return indexCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIndexCount(int newIndexCount)
	{
		int oldIndexCount = indexCount;
		indexCount = newIndexCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputePackage.COMPUTE_EXECUTION_MANAGER__INDEX_COUNT, oldIndexCount, indexCount));
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
			case ComputePackage.COMPUTE_EXECUTION_MANAGER__RECORDERS:
				return ((InternalEList<?>)getRecorders()).basicRemove(otherEnd, msgs);
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
			case ComputePackage.COMPUTE_EXECUTION_MANAGER__RECORDERS:
				return getRecorders();
			case ComputePackage.COMPUTE_EXECUTION_MANAGER__INDEX_COUNT:
				return getIndexCount();
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
			case ComputePackage.COMPUTE_EXECUTION_MANAGER__RECORDERS:
				getRecorders().clear();
				getRecorders().addAll((Collection<? extends ComputeExecutionRecorder>)newValue);
				return;
			case ComputePackage.COMPUTE_EXECUTION_MANAGER__INDEX_COUNT:
				setIndexCount((Integer)newValue);
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
			case ComputePackage.COMPUTE_EXECUTION_MANAGER__RECORDERS:
				getRecorders().clear();
				return;
			case ComputePackage.COMPUTE_EXECUTION_MANAGER__INDEX_COUNT:
				setIndexCount(INDEX_COUNT_EDEFAULT);
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
			case ComputePackage.COMPUTE_EXECUTION_MANAGER__RECORDERS:
				return recorders != null && !recorders.isEmpty();
			case ComputePackage.COMPUTE_EXECUTION_MANAGER__INDEX_COUNT:
				return indexCount != INDEX_COUNT_EDEFAULT;
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
		result.append(" (indexCount: ");
		result.append(indexCount);
		result.append(')');
		return result.toString();
	}

} //ComputeExecutionManagerImpl
