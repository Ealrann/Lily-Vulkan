/**
 */
package org.sheepy.lily.vulkan.model.process.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.api.adapter.LilyEObject;

import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.ProcessPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pipeline Pkg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.impl.PipelinePkgImpl#getPipelines <em>Pipelines</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PipelinePkgImpl extends LilyEObject implements PipelinePkg
{
	/**
	 * The cached value of the '{@link #getPipelines() <em>Pipelines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPipelines()
	 * @generated
	 * @ordered
	 */
	protected EList<IPipeline> pipelines;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PipelinePkgImpl()
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
		return ProcessPackage.Literals.PIPELINE_PKG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IPipeline> getPipelines()
	{
		if (pipelines == null)
		{
			pipelines = new EObjectContainmentEList<IPipeline>(IPipeline.class, this, ProcessPackage.PIPELINE_PKG__PIPELINES);
		}
		return pipelines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case ProcessPackage.PIPELINE_PKG__PIPELINES:
				return ((InternalEList<?>)getPipelines()).basicRemove(otherEnd, msgs);
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
		switch (featureID)
		{
			case ProcessPackage.PIPELINE_PKG__PIPELINES:
				return getPipelines();
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
			case ProcessPackage.PIPELINE_PKG__PIPELINES:
				getPipelines().clear();
				getPipelines().addAll((Collection<? extends IPipeline>)newValue);
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
			case ProcessPackage.PIPELINE_PKG__PIPELINES:
				getPipelines().clear();
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
			case ProcessPackage.PIPELINE_PKG__PIPELINES:
				return pipelines != null && !pipelines.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PipelinePkgImpl
